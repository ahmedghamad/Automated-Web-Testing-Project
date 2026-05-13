Feature: View Product Details

  In order to make an informed purchase decision
  As a shopper
  I want to view detailed information about a product

  Background:
    Given I am on the product details page

  @Happy
  Scenario: Successfully navigate to product details page
    When I click View Product on the first product
    Then the product details page should open
    And the product image should be displayed
    And the product name should be displayed
    And the product price should be displayed
    And the product category should be displayed
    And the product brand should be displayed
    And the product availability should be displayed
    And the product condition should be displayed

  @Happy
  Scenario: Add to Cart button is visible and enabled
    When I click View Product on the first product
    Then the Add to Cart button should be visible and enabled

  @Happy
  Scenario: Quantity field defaults to 1
    When I click View Product on the first product
    Then the quantity field should be visible
    And the quantity field should have a default value of 1

  @Sad
  Scenario: Navigate to non-existent product via URL
    When I navigate to a non-existent product with id 99999
    Then the page should handle it gracefully
    And the application should not crash

#  Submit Product Review

  @Happy
  Scenario: Write Your Review section is visible
    When I click View Product on the first product
    Then the Write Your Review section should be visible

  @Happy
  Scenario: Successfully submit a valid review
    When I enter a valid name "tester"
    And I enter a valid email "tester@test.com"
    And I enter a review message "Great product"
    And I click the Submit Review button
    Then the review should be submitted successfully

  @Sad
  Scenario: Submit review with empty required fields
    When I leave the name field empty
    And I enter a valid email "tester@test.com"
    And I click the Submit Review button
    Then a required field validation message should appear

  @Sad
  Scenario: Submit review with invalid email missing @
    When I enter a valid name "tester"
    And I enter an invalid email "sf"
    And I click the Submit Review button
    Then an invalid email validation message should appear

  @Sad
  Scenario: Submit review with invalid email containing symbols
    When I enter a valid name "tester"
    And I enter an invalid email "sf/::;@SDSA"
    And I click the Submit Review button
    Then a malformed email validation message should appear