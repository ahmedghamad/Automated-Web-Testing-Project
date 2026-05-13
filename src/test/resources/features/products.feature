Feature: Products Page

  In order to browse and purchase products
  As a user of the website
  I want to be able to view products and interact with product cards


  Background:
    Given I am on the products page

#  Browse product

  @Happy
  Scenario: Products page loads successfully
    Given I am on the homepage
    And I click "Products" in the navbar
    Then I should be navigated to the products page
    And the heading "ALL PRODUCTS" should be displayed
    And multiple products should be shown in a grid layout
    And each product should have a name, price and View Product link

  @Happy
  Scenario: Each product card has correct actions
    Given I am on the products page
    Then an Add to Cart button should be visible on each product
    And a View Product link should be visible on each product

  @Happy
  Scenario: Category sidebar is visible on the products page
    Then the category sidebar should be visible

  @Happy
  Scenario: Brands sidebar is visible on the products page
    Then the brands sidebar should be visible

#    Search product

  @Happy
  Scenario: Successful Product Search
    When I enter a valid product keyword "Blue Top"
    And I click the Search button
    Then relevant matching products are displayed
    And the page heading shows "SEARCHED PRODUCTS"
    And all results correspond to the entered keyword

  @Happy
  Scenario: Partial Keyword Search:
    When I enter a partial keyword "top" in the search field
    And I click the Search button
    Then related matching products are displayed

  @Sad
  Scenario: No Matching Products Found
    When I search for a non-existent product "xyzabc123"
    And I click the Search button
    Then no products should be displayed

  @Sad
  Scenario: Empty Search Submission
    Given the search bar is empty
    When I click the Search button
    Then all products remain displayed

  @Sad
  Scenario: Special Characters or Invalid Input
    When I enter special characters "!@£$%" into the search field
    And I click the Search button
    Then the system handles the input safely

#  Filter Products by Category

  @Happy
  Scenario: Filter by Women > Tops category
    When I click the "Women" category in the sidebar
    And I click the "Tops" subcategory
    Then I should be navigated to the category page
    And the page heading should contain "WOMEN - TOPS PRODUCTS"
    And at least one product should be displayed

  @Happy
  Scenario: Filter by Men > Jeans category
    When I click the "Men" category in the sidebar
    And I click the "Jeans" subcategory
    Then I should be navigated to the category page
    And the page heading should contain "MEN - JEANS PRODUCTS"
    And at least one product should be displayed

  @Happy
  Scenario: Filter by Kids > Dress category
    When I click the "Kids" category in the sidebar
    And I click the "Dress" subcategory
    Then I should be navigated to the category page
    And the page heading should contain "KIDS - DRESS PRODUCTS"
    And at least one product should be displayed

  @Sad
  Scenario: Navigating back after filtering returns to products page
    When I click the "Women" category in the sidebar
    And I click the "Tops" subcategory
    And I navigate back
    Then I should be on the products page

#  Filter Products by Brand

  Given the shopper navigates to the home page

  @Happy
  Scenario: Filter products by Kookie Kids brand
    When I click the Kookie Kids brand
    Then I should be navigated to the Kookie Kids brand page

  @Sad
  Scenario: Navigating back after brand filter returns to home page
    When I click the Kookie Kids brand
    And I navigate back
    Then I should be back on the home page

#  Add Product to Cart from Products Page

  @Happy
  Scenario: Successfully add a product to cart from products page
    When I hover over the first product
    And I click Add to Cart on that product
    Then a confirmation modal should appear
    And the modal should display "Your product has been added to cart."
    And the modal should contain a Continue Shopping button
    And the modal should contain a View Cart button

  @Happy
  Scenario: Continue Shopping closes modal and stays on products page
    When I hover over the first product
    And I click Add to Cart on that product
    And I click Continue Shopping
    Then I should remain on the products page

  @Happy
  Scenario: View Cart navigates to the cart page
    When I hover over the first product
    And I click Add to Cart on that product
    And I click View Cart in the modal
    Then I should be navigated to the cart page
    And the product should be visible in the cart
