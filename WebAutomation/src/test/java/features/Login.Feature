Feature: Test facebook

  Background: The user navigates to facebook login page
    Given The user navigates to fb login page

  @smoke
  Scenario: user is able to login to facebook
    Given I login to facebook with the following credentials
      | username              | password  |
      | ramnath1109@gmail.com | tester123 |


  @regression
  Scenario: FB user account creation
    And I create a FB user account with the following information
      | FirstName | LastName | MobileNumber | Password  | Day | Month | Year | Sex  |
      | Ramnath   | Gokul    | 9986040501   | tester123 | 10  | Nov   | 1982 | Male |