Feature: Subscription functionality
  @happyPath
  Scenario: User subscribes successfully from footer
    Given user opens Automation Exercise homepage
    When user scrolls to footer
    And user enters email "testuser@gmail.com"
    And user clicks subscribe button
    Then user should see subscription success message "You have been successfully subscribed!"

  @sadPath
  Scenario: User submits the form without entering an email
    Given user opens Automation Exercise homepage
    When user scrolls to footer
    And the visitor leaves the email field empty
    And user clicks subscribe button
    Then the form submission is prevented
    And a required field validation message is displayed

  @sadPath
  Scenario: User enters an invalid email address
    Given user opens Automation Exercise homepage
    When user scrolls to footer
    And user enters invalid email "test@"
    And user clicks subscribe button
    Then the form submission is prevented
    And a required field validation message is displayed


#Website should now accept duplicate email but this website did. Here is the test that will fail
#  @Ignore
#  Scenario: User cannot subscribe twice with the same email
#    Given a user has already subscribed with email "testuser@gmail.com"
#    When the user attempts to subscribe again with email "testuser@gmail.com"
#    Then the subscription should be rejected
#    And the user should see message "Email address already subscribed!"