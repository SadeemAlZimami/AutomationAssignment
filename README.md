# Automation Test Assignment

This project contains automated tests for validating subscription packages and API functionalities. The tests are written using Selenium WebDriver, Rest Assured and TestNG, and the results are logged using ExtentReports.

## Table of Contents

- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)
- [Viewing Reports](#viewing-reports)

  
## Project Structure


```
project-root/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── api/
│   │       │   ├── BaseApiTest.java
│   │       │   ├── Device.java
│   │       │   ├── DeviceService.java
│   │       │   └── Endpoints.java
│   │       ├── pages/
│   │       │   └── SubscriptionPage.java
│   │       └── utils/
│   │           ├── DriverFactory.java
│   │           ├── ExtentManager.java
│   │           └── SubscriptionData.java
│   └── test/
│       └── java/
│           └── tests/
│               ├── ApiTest.java
│               └── SubscriptionTest.java
├── testng.xml
└── pom.xml
```


## Setup and Installation

### Prerequisites

- Java JDK (version 8 or later)
- Maven (version 3 or later)
- Git

### Clone the Repository

```
git clone [https://github.com/SadeemAlZimami/AutomationAssignment.git]
cd AutomationAssignment
```
### Install Dependencies
Use Maven to install the necessary dependencies:
```
mvn clean install
```


### Running Tests
##Run All Tests
To run all tests defined in the testng.xml file:
```
mvn test -DsuiteXmlFile=testng.xml
```
##un Individual Test Classes
To run individual test classes, you can specify the class name in the Maven command:

```
mvn -Dtest=tests.SubscriptionTest test
mvn -Dtest=tests.ApiTest test

```

### Viewing Reports
After running the tests, an HTML report will be generated in the project root directory as extent-report.html.

Open the report in a web browser to view the detailed test results.

