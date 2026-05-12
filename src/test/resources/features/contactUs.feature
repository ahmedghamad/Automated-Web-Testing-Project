
Feature: Contact Us Form

  @happyPath
  Scenario: Submit contact us form successfully
    Given user launches the application
    When user navigates to Contact Us page
    And user enters name "John Doe"
    And user enters a contact email "john@test.com"
    And user enters subject "Product Inquiry"
    And user enters message "Need more information about your products"
    And user uploads file "src/test/resources/fileToTestContactUsForm.jpg"
    And user clicks submit button
    Then success message should be displayed

  @sadPath
  Scenario: Submit contact us form with no email
    Given user launches the application
    When user navigates to Contact Us page
    And user enters name "John Doe"
    And user enters subject "Product Inquiry"
    And user enters message "Need more information about your products"
    And user uploads file "src/test/resources/fileToTestContactUsForm.jpg"
    And user clicks submit button without accepting alert
    Then the form should not be submitted
    And the user should remain on the Contact Us page

  @sadPath @invalidEmail
  Scenario Outline: Submission with Invalid Email Format
    Given user launches the application
    When user navigates to Contact Us page
    And user enters name "Anne"
    And user enters a contact email "<email>"
    And user enters subject "Test Subject"
    And user enters message "Test message"
    When user clicks submit button without accepting alert
    Then the form should not be submitted
    And the user should remain on the Contact Us page
    Examples:
      | email                  |
      | user@com               |
      | plainaddress           |
      | @missinglocal.com      |
      | missingatsign.com      |
      | missingdomain@         |
      | user@.com              |
      | user@com.              |
      | user..name@example.com |
      | .username@example.com  |
      | username@example       |
      | username@-example.com  |
      | username@example..com  |
      | user name@example.com  |
      | username@@example.com  |