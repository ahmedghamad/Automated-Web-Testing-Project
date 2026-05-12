Feature: Cart Functionality

  @Happy
  Scenario: User adds a product to the cart successfully

    Given the user is on the homepage
    And the user navigates to the products page
    And the user adds a product to the cart
    And the user clicks the View Cart button
    Then the product should be displayed in the cart

  @Happy
  Scenario: User views the shopping cart successfully

    Given the user is on the homepage
    When the user clicks the Cart button
    Then the shopping cart page should be displayed


  @Happy
  Scenario: User removes a product from the cart successfully

    Given the user is on the homepage
    And the user navigates to the products page
    And the user adds a product to the cart
    And the user clicks the View Cart button
    When the user removes the product from the cart
    Then the cart should display an empty cart message

  @Sad
  Scenario: User views an empty cart without products

    Given the user is on the homepage
    When the user clicks the Cart button
    Then the cart should display an empty cart message


  @Sad
  Scenario: User attempts checkout with an empty cart

    Given the user is on the homepage
    And the user clicks the Cart button
    When the user attempts to proceed to checkout
    Then the checkout should not continue


  @Sad
  Scenario: Removed product should no longer appear in cart

    Given the user is on the homepage
    And the user navigates to the products page
    And the user adds a product to the cart
    And the user clicks the View Cart button
    When the user removes the product from the cart
    Then the product should not be displayed in the cart