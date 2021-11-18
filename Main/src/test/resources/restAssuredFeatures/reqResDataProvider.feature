Feature: I am testing post  request for reqres Api with DataProvider

  Scenario: Post request to Add user
    Given reqRes API as the test rest API
    When I want to "ADD" users in "/api/users/create"
    Then I should get the response for "ADD" from Api