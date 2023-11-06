# DaftTestSuite

This project automates the task of searching for a Sale Ad in county Dublin on Daft.ie, checking for results, applying the "garage" keyword filter, and verifying that the filter is correctly applied.

# Prerequisites

Before you begin, make sure you have the following installed on your system:
-Java Development Kit (JDK)
- Apache Maven
- WebDriver (ChromeDriver)
- Selenium WebDriver
- TestNG
## Setup Instructions

1. **Clone the Repository**
   git clone <repository-url>
  
2. Install Dependencies
Use Maven to download the project's dependencies.
mvn clean install
3. Download Chrome or Firefox browser

## Project Configuration
Open the src/main/resources/config.properties file and configure the necessary properties such as the Daft.ie URL and ChromeDriver path.

## Running the Tests
Run mvn test

TestNG generates test reports in the target/surefire-reports directory. Open the HTML report (index.html) in your browser to view the test results.

## Test Structure
The test scenarios are defined in the src/test/java directory.
Page Object Models (POMs) for Daft.ie pages are defined in the src/main/java/pages directory.
Test data and configurations can be managed in the src/main/resources directory.

## Expected Outcome
Upon running the tests, the automation will open the Daft.ie homepage, search for Sale Ads in county Dublin, check for results, apply the "garage" keyword filter, and open one search result to verify that the "garage" keyword is correctly applied on that advert.

If the tests pass, you can be confident that the filtering functionality on Daft.ie is working as expected.
