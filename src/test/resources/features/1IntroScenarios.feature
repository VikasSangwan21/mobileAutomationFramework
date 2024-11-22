Feature: App interactions with scrolling and navigation

  Scenario: Launch app, navigate through pages, and return to home
    Given the app is launched
    When I scroll down to the end of the page
    Then I click on the "My lists" icon
    And I wait for 3 seconds
    Then I click on the "History" icon
    And I wait for 3 seconds
    Then I click on the "Nearby" icon
    And I wait for 3 seconds
    Then I return to the home page by clicking the "Browse" icon
    And I scroll up to the first topic of the app