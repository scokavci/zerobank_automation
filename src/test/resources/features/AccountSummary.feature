Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given user is on the login page
    Given user logs in as authorized user

   @navigation
  Scenario Outline: <account_type> redirect
     When user clicks on "<account_type>" link on the Account Summary page
     Then Account Activity page should be displayed
     And  Account drop down should have "<dropdown_options>" selected
    Examples:
      |account_type|dropdown_options|
      | Savings     | Savings       |
      | Brokerage   | Brokerage     |
      | Checking    | Checking      |
      | Credit Card | Credit Card   |
      | Loan        | Loan          |




