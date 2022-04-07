#Author: Nanthini@your.domain.com
Feature: Realme MobileValidation

  Scenario: Hardcoded values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile
    And user click on the mobile name
    Then user validate the mobile names
    
    @map
Scenario: Data provider values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile by one dim list
    |realme|iphone|SAMSUNG|
    And user click on the mobile name
    Then user validate the mobile names
    
    Scenario: Data table values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile by one dim map
    |1||iphone|
    |2||SAMSUNG|
    |3||realme|
    And user click on the mobile name
    Then user validate the mobile names
    
  Scenario Outline:
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile "<phone>"
    And user click on the mobile name
    Then user validate the mobile names
    
    Examples:
    |phone  |
    |iphone |
    |SAMSUNG|
    |realme |
	
  
    
     

    
