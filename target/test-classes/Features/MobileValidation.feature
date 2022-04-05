#Author: Nanthini@your.domain.com
Feature: Realme MobileValidation

  Scenario: Hardcoded values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile
    And user click on the mobile name
    Then user validate the mobile names
