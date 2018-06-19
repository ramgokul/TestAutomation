Feature: Test dummy feature
  The focus is on testing the dummy feature here

  Scenario Outline: Test something
    Given I am on the login page
    When I enter "<username>" and "<password>"
    Then I should be able to login successfully



    Examples:
      | username | password  |
      | ramnath  | tester123 |
      | user1    | pwd1      |
      | user2    | pwd2      |