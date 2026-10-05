# Student Application Form Test Automation

A UI test automation framework for a **Student Application Form** web application, built with **Java**, **Selenium WebDriver**, **TestNG** and **Maven**, following the **Page Object Model (POM)** design pattern.

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Features](#features)
- [Modules Covered](#modules-covered)
- [Test Coverage](#test-coverage)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup & Execution](#setup--execution)
- [Reports](#reports)
- [Author](#author)

---

## Tech Stack

| Area | Tool / Library | Version |
|---|---|---|
| Language | Java | 17 |
| Build Tool | Maven | 3.x |
| Automation | Selenium WebDriver | 4.22.0 |
| Test Framework | TestNG | 7.9.0 |
| Data-Driven Testing | Apache POI (Excel) | 5.4.1 |
| Reporting | Extent Reports | 5.1.1 |
| Logging | SLF4J Simple | 2.0.9 |
| Browser | Google Chrome | Latest |

---

## Features

- Page Object Model (separate page classes and test classes)
- `BaseClass` for common browser setup and teardown
- Positive and negative test scenarios
- Form field validations (email, mobile number, empty form submission)
- Data-driven testing using Excel (Apache POI)
- TestNG Listeners for test execution events
- Screenshots captured during execution
- Extent HTML reports for detailed results

---

## Modules Covered

| Page Class | Description |
|---|---|
| `SelectFormPage` | Select and open the application form |
| `FormFillPage` | Fill in and submit the student application form |

---

## Test Coverage

### Positive Tests

| Test Class | Scenario |
|---|---|
| `SelectFormPageTest` | Select the form and verify it opens |
| `FormFillPageTest` | Fill the form with valid details and submit |

### Negative Tests

| Test Class | Scenario |
|---|---|
| `EmailValidationTest` | Submit the form with an invalid email address |
| `MobileNumberValidationTest` | Submit the form with an invalid mobile number |
| `EmptyFormSubmissionTest` | Submit the form without filling the required fields |

---

## Project Structure

```
StudentApplicationForm
├── Screenshots                         # Screenshots captured during execution
├── src
│   ├── main
│   │   ├── java/com
│   │   │   ├── applicationFormPages    # Page Object classes
│   │   │   │   ├── FormFillPage.java
│   │   │   │   └── SelectFormPage.java
│   │   │   └── basePage
│   │   │       └── BaseClass.java      # Browser setup and teardown
│   │   └── resources
│   │       └── InputData               # Excel test data
│   └── test/java/com
│       ├── listeners
│       │   └── MyListener.java         # TestNG listener
│       ├── negativeTests
│       │   ├── EmailValidationTest.java
│       │   ├── EmptyFormSubmissionTest.java
│       │   └── MobileNumberValidationTest.java
│       ├── positiveTests
│       │   ├── FormFillPageTest.java
│       │   └── SelectFormPageTest.java
│       └── reports
│           └── ReportManager.java      # Extent report setup
├── ExtentReport.html                   # Generated execution report
├── Testng.xml                          # TestNG suite file
├── pom.xml
├── .gitignore
└── README.md
```

---

## Prerequisites

- JDK 17 or higher
- Maven 3.x
- Google Chrome (latest). Selenium 4.22 manages the ChromeDriver automatically via Selenium Manager
- An IDE such as IntelliJ IDEA or Eclipse

---

## Setup & Execution

1. **Clone the repository**
   ```bash
   git clone https://github.com/BalajiPerumalsamy/StudentApplicationForm.git
   cd StudentApplicationForm
   ```

2. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

3. **Run the tests**
   - From the IDE: right-click `Testng.xml` and choose **Run as TestNG Suite**.
   - From the command line:
     ```bash
     mvn test
     ```
     This runs the suite defined in the TestNG suite file through the Maven Surefire plugin.

---

## Reports

- After execution, the Extent HTML report is generated as `ExtentReport.html` in the project root. Open it in any browser to view pass/fail status and details for each test.
- Screenshots are saved in the `Screenshots` folder.

---

## Author

- **Name:** Balaji Perumalsamy
- **Role:** QA Engineer (Fresher)
- **GitHub:** [BalajiPerumalsamy](https://github.com/BalajiPerumalsamy)
