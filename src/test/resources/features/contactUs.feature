
Feature: Contact Us Form

  @happyPath
  Scenario: Submit contact us form successfully
    Given user launches the application
    When user navigates to Contact Us page
    And user enters name "John Doe"
    And user enters email "john@test.com"
    And user enters subject "Product Inquiry"
    And user enters message "Need more information about your products"
    And user uploads file "src/test/resources/fileToTestContactUsForm.jpg"
    And user clicks submit button
    Then success message should be displayed

  @sadPath
    # missing required field: email
  @sadPath @requiredFields
  Scenario Outline: Submission with Missing Required Fields
    Given user launches the application
    When user navigates to Contact Us page
    And user enters name "<name>"
    And user enters 1 email "<email>"
    And user enters subject "<subject>"
    And user enters message "<message>"
    And user uploads file "src/test/resources/fileToTestContactUsForm.jpg"
    And user clicks submit button without accepting alert
    Then the form should not be submitted
    And the user should remain on the Contact Us page

    Examples:
      | name | email         | subject      | message      |
      |      | anne@test.com | Test Subject | Test message |
      | Anne |               | Test Subject | Test message |
      | Anne | anne@test.com |              | Test message |
      | Anne | anne@test.com | Test Subject |              |

   # Sad path: invalid email
  @sadPath @invalidEmail
  Scenario: Submission with Invalid Email Format
    Given user launches the application
    When user navigates to Contact Us page
    And user enters name "Anne"
    And user enters 1 email "user@com"
    And user enters subject "Test Subject"
    And user enters message "Test message"
    And user clicks submit button without accepting alert
    Then the form should not be submitted
    And an email validation error should be displayed
    And the user should remain on the Contact Us page