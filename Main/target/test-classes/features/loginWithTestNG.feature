Feature: Web Login - Automation Practise Website - with valid credentials
Scenario: user should be able to login with valid credentials
Given the user is on the Home Page
Then follow the Sign in Link
When the user enters valid Credentials to login
And  hits submit button
Then the user found the success text
Then the user clicks on logout
