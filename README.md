# CHQ Automation Framework

Automation framework for the CHQ web application using Selenium, Java, TestNG, and Page Object Model (POM).

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* WebDriverManager
* Apache POI
* Extent Reports
* Log4j

## Project Structure

```text
CHQAutomationFramework
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── DriverFactory.java
│   │   │   ├── pages
│   │   │   │   └── LoginPage.java
│   │   │   ├── tests
│   │   │   │   └── LoginTest.java
│   │   │   ├── utils
│   │   │   │   └── ConfigReader.java
│   │   │   ├── listeners
│   │   │   └── reports
│   │   │
│   │   └── resources
│   │       ├── config
│   │       │   └── config.properties
│   │       ├── testdata
│   │       └── testng.xml
│
├── pom.xml
└── README.md
```

## Features Implemented

* Browser launch using WebDriverManager
* Read configuration from properties file
* Open URL from config file
* TestNG setup
* Page Object Model structure
* Login page automation
* Browser close after test execution

## Dependencies Used

* Selenium Java
* TestNG
* WebDriverManager
* Apache POI
* Extent Reports
* Log4j
* Commons IO

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Update the values in `config.properties`
4. Install Maven dependencies
5. Run `testng.xml`
