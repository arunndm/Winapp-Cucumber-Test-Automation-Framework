Feature: Sign Out Operation

  Scenario: Sign Out Scenario
    Given I see "welcome_screen"
    When I click "more_option" button
    Then I click "signout" button
    When I click "rememberMe_No" button
    Then I see "signinLabel"
    And I click "close_skype" button