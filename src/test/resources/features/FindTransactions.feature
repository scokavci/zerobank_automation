@find_transaction
Feature: Find Transactions in Account Activity

  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user
    And user logs in Account Activity page
    Given user access Find Transactions tab

  @search_date_range
  Scenario: Search date range
    When user enters date range from "2012-09-01" to "2012-09-06"
    Then user should complete process with "Find" button
    Then results table should only show transaction dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    Then user enters date range from "2012-09-02" to "2012-09-06"
    And user should complete process with "Find" button
    Then results table should only show transaction dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  @search_description
  Scenario: Search description
    When user enters description "ONLINE"
    Then user should complete process with "Find" button
    Then results table should only show descriptions containing "ONLINE"
    When user enters description "OFFICE"
    And user should complete process with "Find" button
    But results table should not show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"

  @account_activity_search_description_case_sensitive
  Scenario: Search description case insensitive
    When user enters description "ONLINE"
    And user should complete process with "Find" button
    Then results table should only show descriptions containing "ONLINE"
    When user enters description "online"
    And user should complete process with "Find" button
    Then results table should only show descriptions containing "ONLINE"

  @account_activity_search_transaction_type
  Scenario: Type
    And user should complete process with "Find" button
    Then results table should show at least one result under "Deposit"
    And results table should show at least one result under "Withdrawal"
    When user selects type "Deposit"
    Then user should complete process with "Find" button
    And results table should show at least one result under "Deposit"
    Then results table should show no result under "Withdrawal"
    When user selects type "Withdrawal"
    Then user should complete process with "Find" button
    And results table should show at least one result under "Withdrawal"
    Then results table should show no result under "Deposit"
