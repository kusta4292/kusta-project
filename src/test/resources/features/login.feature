
@TCLOUD10-480
Feature: trycloud app login feature


  Background: For the scenarious in the feature file, user is expected to be on login page
    Given user is on the website login page

  @TCLOUD10-473
  Scenario: User can login with valid credentials by clicking login button

    When user enters valid username "Employee15" into input boxes
    And user enters valid password "Employee123" ito input boxes
    And user clicks to login button
    Then user should see dashboard page

  @TCLOUD10-474
  Scenario: User can login with valid credentials by hitting Enter key

    When user enters valid username "Employee15" into input boxes
    And user enters valid password "Employee123" ito input boxes
    And user hitting Enter key
    Then user should see dashboard page


  @TCLOUD10-475
  Scenario Outline: Login with empty or invalid credentials

    When user log in "<username>" and "<password>" with "<submitType>"
    And user should see invalid credential message Wrong username or password text
    Then user should see usage of empty password or username Please fill out this field text

    Examples:

      | username1         | password1    | submitType   |
      | Employe15         | Employee123  | submitButton |
      | Employe15         |              | submitButton |
      |                   | Employe456   | submitButton |
      |                   |              | submitButton |
      | emploYEE          | eMpLOOYEE987 | enterKey     |
      | EMployeeeaatt567! | sdfghjuh     | enterKey     |
      | 1234567976        | 12345678     | enterKey     |
      | Employee1556      | Employee123  | enterKey     |


  @TCLOUD10-476
  Scenario: Password in a form of dots by default

    When user enters valid password "Employee123" ito input boxes
    Then user sees password in a form of dots

  @TCLOUD10-477
  Scenario:  User can see the password explicitly if needed

    When user clicks to eye icon is need

  @TCLOUD10-478
  Scenario:User can use reset password button

    When user can see forgot password link
    Then user click forgot password link
    And user should see resert password button


  @TCLOUD10-479

  Scenario: User can see valid placeholders on Username and Password fields

    When user see valid placeholder on username
    Then user see valid placeholder on password


  @TCLOUD10-481
    Scenario: Password condition

      When password condition should match given condition "Employee123!"











