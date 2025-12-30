# Selenium Automation Framework

Web test automation framework using Selenium 4, Cucumber 7, and TestNG.

## Technologies

- Java 17
- Selenium 4.27.0
- Cucumber 7.20.1
- TestNG 7.10.2
- Maven

## Setup

1. Clone the repository

2. Configure test credentials:
```bash
cp configuration.properties.example configuration.properties
```

3. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Run tests by tag

Tests are organized by tags. You can run specific test suites by modifying the `@CucumberOptions` tags in `TestRunner.java`:

``` java
@CucumberOptions(
    tags = "@smoke"  // Change this tag
)
```

### Available Tags

| Tag | Description | Example |
|-----|-------------|---------|
| `@smoke` | Critical smoke tests | `tags = "@smoke"` |
| `@login` | All login tests | `tags = "@login"` |
| `@navigation` | Navigation tests | `tags = "@navigation"` |
| `@negative` | Negative test cases | `tags = "@negative"` |
| `@recovery` | Password recovery tests | `tags = "@recovery"` |

### Tag Combinations

You can combine tags using AND/OR operators:

``` java
// Run smoke AND login tests
tags = "@smoke and @login"

// Run smoke OR navigation tests
tags = "@smoke or @navigation"

// Run login tests but NOT negative cases
tags = "@login and not @negative"
```

### Execute Tests

After setting your desired tags in `TestRunner.java`, run:

``` bash
mvn clean test
```

### Run Specific Feature Files

To run a specific feature file:

``` bash
mvn test -Dcucumber.features="src/test/resources/features/login.feature"
```

### Run with Custom Tags (Without modifying TestRunner)

``` bash
mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@login and not @negative"
```

## Project Structure

```
src/test/java/
├── pages/          # Page locators only
├── steps/          # Cucumber step definitions
├── validators/     # Test validations
├── helpers/        # Utility classes
├── driverManager/  # WebDriver setup
└── tests/          # Test runners

src/test/resources/
└── features/       # Cucumber feature files
```

## Reports

### Cucumber HTML Report
After test execution, view the report at:
```
target/cucumber-reports/cucumber.html
```

### Allure Report
Generate and view Allure report:
``` bash
mvn allure:serve
```

## Browser Configuration

Default browser is configured in `CucumberHooks.java:31`:

``` java
driver = DriverManagerFactory.getManager(DriverType.FIREFOX).getDriver();
```

Available options: `CHROME`, `FIREFOX`, `EDGE`

## Test Examples

Current test scenarios:

**Login Tests** (`@login`):
- Successful login with valid credentials
- Failed login with invalid credentials
- Password recovery page access
- Parameterized login tests

**Navigation Tests** (`@navigation`):
- Navigate to Online Banking section

## Adding New Tests

1. Create/update `.feature` file in `src/test/resources/features/`
2. Add step definitions in `src/test/java/steps/`
3. Add validations in `src/test/java/validators/`
4. Add page locators in `src/test/java/pages/`
5. Run tests with appropriate tag

