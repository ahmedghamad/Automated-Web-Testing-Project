Feature: Checkout Functionality

  @Happy
  Scenario: Logged in user successfully places an order

    Given the user is logged into the application
    And the user has added a product to the cart
    And the user proceeds to checkout
    When the user enters an order comment "Please deliver quickly"
    And the user clicks the Place Order button
    And the user enters valid payment details
    Then the order should be placed successfully


  @Happy
  Scenario: User verifies delivery and billing address during checkout

    Given the user is logged into the application
    And the user has added a product to the cart
    When the user proceeds to checkout
    Then the delivery address should be displayed correctly
    And the billing address should be displayed correctly

  @Happy
  Scenario: User successfully downloads invoice after purchase

    Given the user has successfully placed an order
    When the user clicks the Download Invoice button
    Then the invoice should be downloaded successfully

  @Happy
  Scenario: User reviews products before placing order

    Given the user has added multiple products to the cart
    When the user proceeds to checkout
    Then the order review section should display all products
    And the total amount should be displayed correctly

  @Sad
  Scenario: User attempts checkout with an empty cart

    Given the user has an empty cart
    When the user navigates to the checkout page
    Then the checkout page should not allow order placement


  @Sad
  Scenario: User attempts payment with invalid card details

    Given the user is on the payment page
    When the user enters invalid card information
    And the user clicks Pay and Confirm Order
    Then the payment should fail


  @Sad
  Scenario: User attempts checkout without logging in

    Given the user is not logged in
    And the user has added a product to the cart
    When the user proceeds to checkout
    Then the user should be redirected to the login page


  @Sad
  Scenario: User attempts to place order without payment information

    Given the user is on the payment page
    When the user leaves all payment fields empty
    And the user clicks Pay and Confirm Order
    Then validation messages should be displayed


  @Sad
  Scenario: User refreshes checkout page during order process

    Given the user is on the checkout page
    When the user refreshes the browser
    Then the cart products should still be displayed