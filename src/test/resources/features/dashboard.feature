Feature: Trycloud dashboard enter attempt


  @TCLOUD10-481
  Scenario: User can login with valid credentials by clicking login button
    Given user has already the website login page
    And user enters valid username into input boxes
    Then user enters valid passwordinto input boxes
    Then should not see the dashboard again after closing