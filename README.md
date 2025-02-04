# Practice Software Testing Automation Framework

This framework implements automated tests for the Practice Software Testing website using Java, Selenium WebDriver, Cucumber, and TestNG.

## Framework Structure

```
src/
  test/
    java/
      com/
        practice/
          config/      # Configuration and driver management
          pages/       # Page Object Models
          steps/       # Cucumber step definitions
          utils/       # Helper utilities
    resources/
      features/        # Cucumber feature files
      config.properties
```

## Setup

1. Prerequisites:
    - Java JDK 11 or higher
    - Maven
    - Chrome/Firefox browser

2. Dependencies (add to pom.xml):
    - Selenium WebDriver
    - Cucumber
    - TestNG
    - WebDriverManager

## Running Tests


1. Via TestNG:
    - Run the TestNG XML configuration file

## Design Choices

1. Page Object Model (POM)
    - Separates test logic from page interactions
    - Makes tests more maintainable
    - Reduces code duplication

2. Cucumber BDD
    - Business-readable test scenarios
    - Reusable step definitions
    - Clear test documentation

3. Configuration Management
    - Externalized configuration in properties file
    - Easy to switch environments and browsers

4. Thread-safe WebDriver
    - Supports parallel test execution
    - Uses ThreadLocal for driver instances

## Test Coverage

1. Contact Form
    - Validation of empty fields
    - Successful form submission

2. Shopping Cart
    - Add to cart functionality
    - Quantity updates
    - Price calculation verification