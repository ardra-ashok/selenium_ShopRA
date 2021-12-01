Feature: feature file Opal.com for autload operations

  Background:
    Given I set the test environment to "ETS-ITF"
    And I check that "ETS" VPN is connected


  Scenario: Autoload setup

    Given I set the test environment to "ETS-ITF"
    And I check that "ETS" VPN is connected

    When I launch "opal.website" website

    And I login to opal website with credentials
      | TOPUPSEL  | Qwerty123 |

    Then I should be able to see the list of opal cards in Opal Account Overview page

    And I setup smartcard autoload with the following
      | Card Number              | Amount |
      |  3085 2200 3425 3225     | 20     |
#      |  3085 2207 0204 6281     | 20     |

    And I remove Autoload from the smartcard with the following cards
      | Card Number              |
      |  3085 2200 3425 3225     |

    And I log out from opal website
