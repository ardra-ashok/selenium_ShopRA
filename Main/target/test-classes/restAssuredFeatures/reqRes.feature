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

#  Scenario: API should post, put, and patch the data according to the Selection
#    Given reqRes API as the rest API
#    When I hit the api with "post" with the following data
#      | url_param      |  | parameter_value           |
#      | {"name","job"} |  | { "mira","tech-support" } |
#  Then API should add the details to the system

#  Scenario: API should post, put, and patch the data according to the Selection
#    Given reqRes API as the rest API
#    When I hit the api with "post" with the following data

#  Scenario: API should post, put, and patch the data according to the Selection
#    Given reqRes API as the rest API
#    When I hit the api with "patch" with the following data

  Scenario: API should post, put, and patch the data according to the Selection
    Given reqRes API as the rest API
    When I hit the api with  with the following data
      | request | values                                  | endPoint            |
      | post    | { "name":"mira","job":"tech-support" }  | /api/users/create   |
      | put     | { "name":"steven","job":"it-support" }  | /api/users/update/1 |
      | patch   | { "name":"steve","job":"tech-support" } | /api/users/update/1 |