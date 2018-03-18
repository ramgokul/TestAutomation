Feature: Test facebook

  Background: The user navigates to facebook login page
    Given The user navigates to fb login page

  Scenario: user is able to login to facebook
    Given I login to facebook with the following credentials
      | username              | password  |
      | ramnath1109@gmail.com | tester123 |
