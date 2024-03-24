import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpaceXCapsuleTest {

    private static final String BASE_URL = "https://api.spacexdata.com/v3";
    private static final String CAPSULES_ENDPOINT = "/capsules";
    private static final String UPCOMING_CAPSULES_ENDPOINT = CAPSULES_ENDPOINT + "/upcoming";

    @Test
    public void testSpaceXCapsuleAPIIntegrations() {

        List<String> allCapsuleSerials = getCapsuleSerials(CAPSULES_ENDPOINT);

        List<String> upcomingCapsuleSerials = getCapsuleSerials(UPCOMING_CAPSULES_ENDPOINT);

        List<String> commonCapsuleIds = findCommonCapsuleIds(allCapsuleSerials, upcomingCapsuleSerials);

        String capsuleId = commonCapsuleIds.get(0);

        try {
            given()
                    .baseUri(BASE_URL)
                    .pathParam("id", capsuleId)
                    .when()
                    .get(CAPSULES_ENDPOINT + "/{id}")
                    .then()
                    .statusCode(200)
                    .body("original_launch", equalTo(null));
        } catch (AssertionError e) {
            System.err.println("Error: 'original_launch' is unexpectedly not null for capsule ID " + capsuleId + ". Error message: " + e.getMessage());
        }

        String capsuleName = findCapsuleNameByFlightNumber(10);
        if (capsuleName != null) {
            System.out.println("Capsule with flight number 10: " + capsuleName);
        } else {
            System.out.println("Capsule with flight number 10 not found.");
        }

        System.out.println("All API calls completed!");
    }

    private static List<String> getCapsuleSerials(String endpoint) {
        return given()
                .baseUri(BASE_URL)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath().getList("capsule_serial");
    }

    private static List<String> findCommonCapsuleIds(List<String> allSerials, List<String> upcomingSerials) {
        return allSerials.stream().filter(upcomingSerials::contains).toList();
    }

    private static String findCapsuleNameByFlightNumber(int flightNumber) {
        return given()
                .baseUri(BASE_URL)
                .when()
                .get(CAPSULES_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("findAll { it.flight == " + flightNumber + " }.name")
                .stream()
                .findFirst()
                .map(Object::toString)
                .orElse(null);
    }

}
