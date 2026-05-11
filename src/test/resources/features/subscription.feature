Feature: Subscription functionality

  Scenario: User subscribes successfully from footer

    Given user opens Automation Exercise homepage
    When user scrolls to footer
    And user enters email "testuser@gmail.com"
    And user clicks subscribe button
    Then user should see subscription success message "You have been successfully subscribed!"