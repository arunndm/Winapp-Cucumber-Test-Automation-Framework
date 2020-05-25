Feature: Sign In Operation

  Scenario: Sign In Scenario
    Given I see "signinLabel"
    When I click "signinLabel" button
    And I provide "arun_ndm@yahoo.com" in textbox "username"
    And I click "Next" button
    And I provide "Nura@3010" in textbox "password"
    And I click "signin" button
    Then I see "welcome_screen"