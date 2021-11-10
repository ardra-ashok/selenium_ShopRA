Feature: Web Login - Automation Practise Website - with valid credentials
  Scenario: user should be able to login with valid credentials
    Given the user is on the Home Page
    Then follow the Sign in Link
    When the user enters valid Credentials to login
      | email                    | password |
      | test1249@test.com        | PKR@PKR  |
    And hits submit button
    Then the user found the success text
    Then the user clicks on logout
    Then user then closes the browser


#  Scenario for credentials class
#  Scenario: Successful Login with Valid Credentials2
#    When User enters Credentials to LogIn page
#      | email                    | password |
#      | test1249@test.com        | PKR@PKR  |
#      | testemailardra@gmail.com | PKR@PKR  |
#    When hits submit for success login2
#    Then Message displayed Login Successfully
#    Then the user should logged out successfully2

