# American Express UI Test Automation Framework

## Overview
This repository contains the **American Express UI Test Automation Framework**, developed using **Selenium with Java and Cucumber**, following the **Page Object Model (POM)** design pattern. This framework is designed to automate and validate the UI elements in the **FR credit card application flow**.

## Features
- **Selenium WebDriver** for UI automation
- **Cucumber BDD** for behavior-driven testing
- **Page Object Model (POM)** for maintainability
- **Explicit waits** for reliable element interactions
- **Logging and reporting** for better debugging
- **Git integration** for version control

## Prerequisites
Ensure you have the following installed before setting up the project:
- **Java 11 or later**
- **Maven** (for dependency management)
- **Eclipse/IntelliJ** (recommended IDE)
- **Google Chrome** (latest version)
- **ChromeDriver** matching your Chrome version
- **Git** (for version control)

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/deepa1994/AmericanExpress.git
cd AmericanExpress
```

### 2. Import the Project into Eclipse/IntelliJ
- Open your IDE and select **File > Open Project**.
- Choose the cloned project directory.
- Ensure Maven dependencies are loaded properly.

### 3. Configure WebDriver
- Update the **chromedriver.exe** path in the configuration if necessary.
- The driver is managed via `WebDriverManager`, so it will be downloaded automatically.

### 4. Run the Tests
Execute the following command to run the tests:
```sh
mvn clean test
```

To run specific test scenarios, use:
```sh
mvn test -Dcucumber.options="--tags @SmokeTest"
```

### 5. View Test Reports
- **Cucumber HTML Reports** will be generated in `target/cucumber-reports/`.
- Open `index.html` in a browser to view the test execution report.

## Project Structure
```
AmericanExpress/
│── src/test/java/
│   ├── stepDefinitions/    # Step definitions for Cucumber
│   ├── runners/            # Cucumber test runners
│   ├── pages/              # Page Object Model (POM) classes
│   ├── utils/              # Utility classes (WebDriver setup, waits, etc.)
│── src/test/resources/
│   ├── features/           # Cucumber feature files
│   ├── config/             # Configuration files
│── pom.xml                 # Maven dependencies and plugins
│── README.md               # Project documentation
```

## Contributing
1. **Fork the repository**.
2. **Create a new branch** (`git checkout -b feature-branch`).
3. **Commit your changes** (`git commit -m 'Add new feature'`).
4. **Push to your branch** (`git push origin feature-branch`).
5. **Create a pull request** on GitHub.

## Issues & Support
If you encounter any issues or have questions, feel free to open an **issue** in this repository or contact the repository owner.

---
**Maintainer:** [Deepa1994](https://github.com/deepa1994)  
**License:** MIT

