Feature: Contact Form Functionality

  Scenario: Submit contact form with empty fields
    Given I am on the contact page
    When I submit the form without filling any fields
    Then I should see validation errors

  Scenario: Submit contact form with valid data
    Given I am on the contact page
    When I fill in the contact form with valid data
    And I submit the form
    Then I should see a success message
