
Feature: I am testing get, put, post and delete request for Go Rest API
#  Scenario: Get request to fetch all users
#    Given Go rest API is up and running
#    When I hit the api with get request and end point as "/public/v1/users"
#    Then API should return all the users
#
#  Scenario: Get request to fetch single User
#    Given Go rest API is up and running
#    When I hit the api with get request and end point as "/public/v1/users/11"
#    Then API should return user details of user id "11"
#
#  Scenario: API should get response status code as 404 for incorrect user
#    Given Go rest API is up and running
#    When I hit the api with get request and end point as "/public/v1/users/6453453555353535353453"
#    Then API should return user not found response for id "6453453555353535353453"


  Scenario: Post request to create a user in the Go Rest DB
    Given Go rest API is up and running
    And I set header and body to create new user
    When I hit the api with post request and end point as "/public/v1/users"
    Then API created a new User in the system
    And I can find the new user in the system when i get the user

#  Scenario: Post request to validate error message when no body is sent
#    Given Go rest API is up and running
#    And I set header and but with out any body
#    When I hit the api with post request and end point as "/public-api/users"
#    Then API returned the error code as 422
#    And error message displayed as "Email cannot be blank."
#    And error message displayed as "First Name cannot be blank."
#    And error message displayed as "Last Name cannot be blank."
#    And error message displayed as "Gender cannot be blank."

#  Scenario: Delete request to update user in the Go Rest DB
#    Given Go rest API is up and running
#    When I hit the api with delete request
#    Then get request to the user should not return the user

#  Scenario: Patch request to update user in the Go Rest DB
#    Given Go rest API is up and running
#    When I hit the api with patch request to update the existing user details
#    Then API should update the user

#  Scenario: Put request to update user in the Go Rest DB
#    Given Go rest API is up and running
#    Then I have a new user created in the system
#    When I hit the api with put request to update the existing user details
#    Then API should update the user
#    And get request to the user should return updated information