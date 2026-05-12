Feature:Home Page
  As a shopper
  I want to arrive to the home page
  So that I can browse what items I want

  # ───── HAPPY PATHS ─────

  Scenario: Featured items are visible on the homepage
    Given the shopper navigates to the home page
    Then the featured items section should be visible
    And the featured items should be accessible

  Scenario: Category filter is visible on the homepage
    Given the shopper navigates to the home page
    Then the category filter should be visible
    And the category filter should be accessible

  Scenario: Brands filter is visible on the homepage
    Given the shopper navigates to the home page
    Then the brands filter should be visible
    And the brands filter should be accessible

  Scenario: Navigation bar is visible on the homepage
    Given the shopper navigates to the home page
    Then the navigation bar should be visible
    And the navigation bar should be accessible

