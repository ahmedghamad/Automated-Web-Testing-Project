Feature: Subscription functionality
# ----Happy path----
  Scenario: User subscribes successfully from footer

    Given user opens Automation Exercise homepage
    When user scrolls to footer
    And user enters email "testuser@gmail.com"
    And user clicks subscribe button
    Then user should see subscription success message "You have been successfully subscribed!"

# ----Sad path----
# Empty email
  Scenario: User submits the form without entering an email
    Given the subscription form is visible
    When the visitor leaves the email field empty
    And clicks the Subscribe button
    Then the form submission is prevented
    And a required field validation message is displayed

# Invalid email
#  Scenario: User enters an invalid email address
#    Given the visitor is on the website
#    When the visitor enters invalid email "test@invalid"
#    And clicks the Subscribe button
#    Then the subscription is not submitted
#    And an error message is displayed

##Already registered email
#  Scenario: User subscribes with an already registered email
#    Given the email address already exists in the subscription database
#    When the visitor enters the same email address "testuser@gmail.com"
#    And clicks the Subscribe button
#    Then the system displays an informative message
#    And duplicate subscription is prevented