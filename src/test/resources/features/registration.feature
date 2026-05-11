Feature: User Registration
  As a new user,
  I want to register an account,
  So that I can access the application as a registered customer.

  Background:
    Given the user is on the Home page
    When the user clicks the Signup/Login button

  @Happy
  Scenario: Successful user registration with valid details

    And the user enters a name "Test_User"
    And the user enters a unique valid email address
    And the user clicks the Signup button
    And the user completes the registration form with valid details
    And the user clicks the Create Account button
    Then the account should be created successfully
    And the "ACCOUNT CREATED!" message should be displayed

  @Sad
  Scenario: User registration with an already registered email

    And the user enters a name "Test_User"
    And the user enters an already registered email address "testuser1@outlook.com"
    And the user clicks the Signup button
    Then the user should see an error message "Email Address already exist!"
    And the account should not be created

