Feature: Web Login - Automation Practise Website - with valid credentials and invalid Credentials

Background: User on Home Page and click sign in for Sign in page
  Given the user is on the Home Page
  And follow the Sign in Link


  Scenario Outline: user should be able to login with valid credentials
    When the user enters valid credentials - "<email>" and "<password>"
    And hits submit for success login
    Then the user should be logged in successfully
    Then the user should logged out successfully
  Examples:
    | email             | password |
    | test1249@test.com | PKR@PKR  |

  Scenario Outline: user should not be able to login with invalid credentials
  When the user enters invalid credentials - "<email>" and "<password>"
    And hits submit for unsuccessful login
    Then the user should not be logged in successfully

    Examples:
      | email            | password |
      | test1249@test.co | PKR@PKR  |

  Scenario: user should be able to login with valid credentials
    When the user enters valid Credentials to login
      | email                    | password |
      | test1249@test.com        | PKR@PKR  |
    And hits submit for success login1
    Then the user found the success text
    Then the user should logged out successfully

  Scenario: Successful Login with Valid Credentials
    When User enters Credentials to LogIn page
      | email                    | password |
      | test1249@test.com        | PKR@PKR  |
      | testemailardra@gmail.com | PKR@PKR  |
    When hits submit for success login2
    Then Message displayed Login Successfully
    Then the user should logged out successfully2

