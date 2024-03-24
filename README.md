
# Building from Source
This guide outlines the steps for building and running tests within the MdCaseStudy project.

### 1. Prerequisites

Before you begin, ensure you have the following software installed on your system:

- Java 11 or above: Download and install Java from the official website if you don't have it already: https://www.oracle.com/java/technologies/downloads/

- Apache Maven: Maven is a project management and build automation tool. Download and install it from the official website: https://maven.apache.org/

### 2. Setup

#### 1. Clone the Project:

Use Git to clone the project repository to your local machine by running the following command in your terminal:
```
git clone https://github.com/okanbas01/MdCaseStudy.git
```

#### 2.Navigate to Project Directory:
Change your working directory to the newly cloned project folder using the following command:
```
cd MdCaseStudy
```

#### 3.Compile the Project (using Maven):
Execute the following command in your terminal to compile the project using Maven:
```
mvn clean install
```
- clean: Removes any previously compiled class files.
- install: Builds the project and installs it in your local Maven repository.

### 3. Running the Tests

#### 1.Run Tests with Maven:
To run all test cases using Maven, execute the following command:
```
mvn test
```
This command instructs Maven to discover and execute all test classes within the project.

#### 2.Run Tests with IDE (Optional):
If you prefer using an IDE for development, most IDEs like IntelliJ IDEA, Eclipse, or NetBeans offer built-in test runners. Refer to your IDE's documentation for specific instructions on running tests.

### Test Case Link

A detailed breakdown of individual test cases, expected results, or additional notes can be found in the project's test case document located at:

Test Cases: https://docs.google.com/spreadsheets/d/1uBef_mpzS_mq6Uf6rNdDtJbm26tlqcJP7Jr9w0I-1s4/edit?usp=sharing

This document may be helpful for gaining a deeper understanding of the testing process.

I hope this information helps you build the MdCaseStudy project from source and run the tests!
