Feature: Site Navigation
  As a user of the e-commerce system
  I want to be able to navigate through different sections
  So that I can browse products and manage my shopping cart

  Background:
    Given the user is on the home page
    When the user enters valid credentials
    And the user clicks on the Sign In button

  @smoke @navigation
  Scenario: Navigation to Shopping Cart
    When the user clicks on the shopping cart
    Then the shopping cart should be visible

  @navigation @products
  Scenario: View products after login
    Then the products page should be visible
