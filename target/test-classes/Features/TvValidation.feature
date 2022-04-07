@TV
Feature: TvValidation

  Scenario: Hardcoded values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search TV
    And user click on the TV name
    Then user validate the TV names
