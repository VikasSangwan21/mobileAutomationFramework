Feature: Launch Android emulator and open the app

  Scenario: Launch emulator and verify app opens successfully
    Given the Android emulator is started
    When the app is launched from the APK file
    Then the app should open successfully
    And I verify the app title is "My App Title"
