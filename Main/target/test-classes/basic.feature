  @abc
  Feature: Web login

  @Functional
  Scenario: Attempt to login with valid credentials
    Given the user is on login page
    When the user enters valid credentials
    And hits submit
    Then the user should be logged successfully

  @regression
  Scenario: Attempt to login with invalid credentials
    Given the user is in login page
    When the user enters invalid credentials
    And hits submit button
    Then the user not logged in successfully