Feature: Products Page

  In order to browse and purchase products
  As a user of the website
  I want to be able to view products and interact with product cards

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
    Given I am on the products page
    Then the category sidebar should be visible

  @Happy
  Scenario: Brands sidebar is visible on the products page
    Given I am on the products page
    Then the brands sidebar should be visible

#    Search product
  @Happy
  Scenario: Successful Product Search
    Given I am on the products page
    When I enter a valid product keyword "Blue Top"
    And I click the Search button
    Then relevant matching products are displayed
    And the page heading shows "SEARCHED PRODUCTS"
    And all results correspond to the entered keyword

  @Happy
  Scenario: Partial Keyword Search:
    Given I am on the products page
    When I enter a partial keyword "top" in the search field
    And I click the Search button
    Then related matching products are displayed

  @Sad
  Scenario: No Matching Products Found
    Given I am on the products page
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
    Given I am on the products page
    When I enter special characters "!@£$%" into the search field
    And I click the Search button
    Then the system handles the input safely
