Feature: Login
  As a registered user,
  I want to login to the application,
  So that I can access my account.

  Background:
    Given the user is on the Home page
    When the user clicks the Signup/Login button

  @Happy
  Scenario: User login with valid credentials

    And the user enters a valid email address "testuser1@outlook.com"
    And the user enters a valid password "Test@123"
    And the user clicks the Login button
    Then the user should be logged in successfully

  @Sad
  Scenario Outline: User login with invalid passwords

    And the user enters a valid email address "testuser1@outlook.com"
    And the user enters an invalid password "<password>"
    And the user clicks the Login button
    Then the user should see a login error message "Your email or password is incorrect!"

    Examples:
      | password |
      | flower   |
      | 12345    |
      | Test123  |
