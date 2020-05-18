@account_activity
Feature: Account Activity
   As a user I should be able to see under Account Activity page, all dropdown
  options and transaction table(column names) should be displayed

  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user

  Scenario:
    Then user verify the title of Account Activity Page as "Zero - Account Activity"
    And  view default option as "Savings" in the Account drop down
    Then view dropdown options in the Account should have following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then view transactions table column names should have the following options
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |



