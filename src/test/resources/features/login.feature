Feature: Login Functionality
  As a user of the e-commerce system
  I want to be able to log in
  So that I can access the products and shop online

  Background:
    Given the user is on the home page

  @smoke @login
  Scenario: Successful login with valid credentials
    When the user enters valid credentials
    And the user clicks on the Sign In button
    Then the user should be logged in successfully

  @smoke @login @negative
  Scenario: Failed login with invalid credentials
    When the user enters invalid credentials
    And the user clicks on the Sign In button
    Then an error message should be displayed
    And the user should not be logged in

  @login @parametrized
  Scenario Outline: Login with different credentials
    When the user enters username "<username>" and password "<password>"
    And the user clicks on the Sign In button
    Then <result>

    Examples:
      | username      | password     | result                                    |
      | standard_user | secret_sauce | the user should be logged in successfully |
      | invalid_user  | wrong_pass   | an error message should be displayed      |
      | locked_out_user | secret_sauce | an error message should be displayed    |
