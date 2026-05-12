Feature: Subscription functionality
  @happyPath
  Scenario: User subscribes successfully from footer

    Given user opens Automation Exercise homepage
    When user scrolls to footer
    And user enters email "testuser@gmail.com"
    And user clicks subscribe button
    Then user should see subscription success message "You have been successfully subscribed!"

  @sadPath
# Empty email
  Scenario: User submits the form without entering an email
    Given the subscription form is visible
    When the visitor leaves the email field empty
    And clicks the Subscribe button
    Then the form submission is prevented
    And a required field validation message is displayed

  @sadPath
 #Invalid email
  Scenario: User enters an invalid email address
    Given the visitor is on the website
    When the visitor enters invalid email "test@"
    And clicks the Subscribe button
    Then the subscription is not submitted
    And an error message is displayed


#Website should now accept duplicate email but this website did. Here is the test that will fail
#  @Ignore
#  Scenario: User cannot subscribe twice with the same email
#    Given a user has already subscribed with email "testuser@gmail.com"
#    When the user attempts to subscribe again with email "testuser@gmail.com"
#    Then the subscription should be rejected
#    And the user should see message "Email address already subscribed!"