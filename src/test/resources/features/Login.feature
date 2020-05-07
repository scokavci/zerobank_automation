Feature: Login

  Background: open login page
    Given user is on the login page

  @authorized_users
  Scenario:Log in as authorized user and verify Account summary page displayed
     When user logs in as authorized user
     Then user should verify that Account summary page is displayed

  @non_authorized_users
  Scenario: non-authorized user cannot log in and verify error message
    When user tries to login with invalid credentials
    Then error message "Login and/or password are wrong." should be displayed