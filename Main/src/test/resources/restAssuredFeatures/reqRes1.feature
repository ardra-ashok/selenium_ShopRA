Feature: I am testing get, put, post and delete request for reqres Api

  Background:
    Given reqRes API as the test rest API

  Scenario: Get request to fetch all users
    When I want to "GET" details of the user from "/api/users"
    Then I should get the response for "GET" from Api

  Scenario: Get request to delete user
    When I want to "DELETE" user from "/api/users/2"
    Then I should get the response for "DELETE" from Api

  Scenario: Post request to Add user
    When I want to "ADD" users to "/api/users/create"
      | name        | job          |
      | Steven Ruth | Tech-support |
      | Nate Mac    | IT-support   |
      | Sam Michael | Developer    |
    Then I should get the response for "ADD" from Api

  Scenario: Put request to Edit user
    When I want to "EDIT" user details in "/api/users/update"
      | id | email                 |
      | 1  | georg.bluth@reqres.in |
      | 2  | jane.weaver@reqres.in |
    Then I should get the response for "EDIT" from Api

  Scenario: Get request to get single user details
    When I want to get user details from "/api/users"
      | id |
      | 1  |
      | 2  |
    Then I should get the response for "GET" from Api

