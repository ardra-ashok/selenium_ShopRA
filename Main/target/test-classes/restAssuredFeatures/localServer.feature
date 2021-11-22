Feature: Practicing CRUD on local Server

  Background:
    Given I set the environment to local server

#  Scenario: Testing the post operation in local Server
#    Then I send a "Create Post" API request with the following data
#      | title        | 400 days      |
#      | author       | Chetan Bhagat |
#      | responseCode | 201           |


#    Scenario: Testing Delete operation in local Server
#      Then I send a create post request with the following data to perform "delete post" Api request,and get gave a Not Found
#        | title        | half girl friend |
#        | author       | Chetan Bhagat    |
#        | responseCode | 404              |
#
#
  Scenario: Testing PUT operation in local Server
    Then I send a create post API request with the following data
      | title        | half girl friend |
      | author       | Chetan Bhagat    |
      | responseCode | 201              |
    Then i "update post" with the following data
      | title        | 400 days      |
      | author       | Chetan Bhagat |
      | responseCode | 200           |