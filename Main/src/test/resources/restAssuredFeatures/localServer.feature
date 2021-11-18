Feature: Practicing CRUD on local Server
  Scenario: Testing the CRUD operation in local Server
    Given I set the environment to local server
    Then I send a "Create Post" API request with the following data
      | title    | author        | responseCode |
      | mary-com | mary          | 201          |
      | 400-days | Chetan Bhagat | 201          |

