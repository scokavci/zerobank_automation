Feature: Find Transactions in Account Activity

  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user
    And user logs in Account Activity page
    Given user access Find Transactions tab

  @search_date_range
  Scenario: Search date range
    When user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transaction dates between "2012-09-01" to "2012-09-06"

  @search_description
  Scenario: Search description
    When user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    But results table should not show descriptions containing "OFFICE"

  Scenario: Search description case insensitive
    When user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"

  @type
  Scenario: Type
    And click "Deposit" type
    And clicks search
    Then results table should show at least one result under Deposit