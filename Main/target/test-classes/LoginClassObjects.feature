Feature: Login Action
Scenario: Successful Login with Valid Credentials
  Given the user is on the Home Page
  And follow the Sign in Link
  And User enters Credentials to LogIn
  | email                    | password |
  | test1249@test.com        | PKR@PKR  |
  | testemailardra@gmail.com | PKR@PKR  |
  Then Message displayed Login Successfully
  Then the user should logged out successfully
