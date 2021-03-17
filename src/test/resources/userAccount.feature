Feature: User Account Management
  As a user
  I want to set up and manage the user account
  So that I can get access to the authorized users features

  Scenario: Check Log In Page
    Given User opens 'https://www.asos.com/' page
    And User checks the header visibility
    When User clicks on 'Sign In' button
    And User checks email and password fields visibility on the login form
    And User enters email and password of non-existing user
    And Users clicks 'Sign In' button on the Log In page
    Then User checks that the validation error popup is displayed


  Scenario: Check Register Page
    Given User opens 'https://www.asos.com/' page
    And User checks the header visibility
    When User clicks on 'Join' button
    Then User checks fields visibility on the registration form
    And Users checks 'Join ASOS' button visibility


  Scenario: Check Forgot Password Page
    Given User opens 'https://www.asos.com/' page
    And User checks the header visibility
    When User clicks on 'Sign In' button
    And User clicks on the 'Forgot Password' button
    Then User checks the email field and 'Reset Password' button are visible
