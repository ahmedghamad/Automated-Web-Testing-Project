Feature: Contact Us Form Submission

  Background:
    Given the user is on the Contact Us page

  @happyPath
  Scenario: Successful Contact Form Submission
    When the user enters a valid name
    And the user enters a valid email address
    And the user enters a subject
    And the user enters a message
    And the user uploads a file
    And the user clicks the Submit button
    And the user accepts the confirmation alert
    Then the form should be submitted successfully
#    And the user should see the message "Success! Your details have been submitted successfully"

#  @sadPath @requiredFields
#  Scenario Outline: Submission with Missing Required Fields
#    When the user enters name "<name>"
#    And the user enters email "<email>"
#    And the user enters subject "<subject>"
#    And the user enters message "<message>"
#    And the user uploads a file
#    And the user clicks the Submit button
#    Then the form should not be submitted
#    And the user should remain on the Contact Us page
#
#    Examples:
#      | name | email         | subject      | message              |
#      |      | anne@test.com | Test Subject | Test message         |
#      | Anne |               | Test Subject | Test message         |
#      | Anne | anne@test.com |              | Test message         |
#      | Anne | anne@test.com | Test Subject |                      |
#
#  @sadPath @invalidEmail
#  Scenario: Submission with Invalid Email Format
#    When the user enters a valid name
#    And the user enters an invalid email address "user@com"
#    And the user enters a subject
#    And the user enters a message
#    And the user clicks the Submit button
#    Then the form should not be submitted
#    And an email validation error should be displayed
#    And the user should remain on the Contact Us page