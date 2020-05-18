Feature: Add new payee under pay bills
  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user
    And user clicks on PayBills page

  @add_new_payee
  Scenario: Add a new payee
    Given click New Payee tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
    Then "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed