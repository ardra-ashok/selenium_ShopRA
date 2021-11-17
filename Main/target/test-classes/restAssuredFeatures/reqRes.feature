Feature: I am testing get, put, post and delete request for Regres Api
#  Scenario: Get request to fetch all users
#    Given reqRes API as the rest API
#    When I hit the api with get request and end point as "/api/users",API returns all the users

#  Scenario: Get request to fetch single User
#    Given reqRes API as the rest API
#    When I hit the api with get request and end point as "/api/users/11",API returns single user with id as <11>

#  Scenario: Get request to fetch single User
#    Given reqRes API as the rest API
#    When I hit the api with get request and end point as "/api/users?page=1",and select page <1>

#  Scenario: API should get response status code as 404 for incorrect user
#    Given reqRes API as the rest API
#    When I hit the api with get request and end point as "/api/users/24",API should return user not found response for wrong id


  Scenario: API should post the data
    Given reqRes API as the rest API
    When I hit the api with "post" with the following data

##  Scenario: API should patch the data
##    Given reqRes API as the rest API
##    When I hit the api with "patch" with the following data
#
#  Scenario: API should post, put, and patch the data according to the Selection
#    Given reqRes API as the rest API
#    When I hit the api with "post" with the following data
#      | url_params | parameter_value |
