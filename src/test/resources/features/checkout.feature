Feature: Checkout Functionality

  @Happy
  Scenario: Logged in user successfully places an order

    Given I am logged in using email "spartatest@outlook.com" and password "Sh$hDSHs84@393"
    And the user has added a product to the cart
    When the user proceeds to checkout
    And the user clicks the Place Order button
    And the user enters valid payment details
    Then the order page should display a confirmation message

