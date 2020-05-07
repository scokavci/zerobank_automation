Feature: Statements and Documents details

  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user


  @recent_statements
  Scenario Outline: Recent statements per year
    Given user accesses the Statements & Documents tab
    When  user selects the Recent Statements Year <year>
    Then  <count> statements should be displayed for that year
    Then logout
    Examples:
      | year | count |
      | 2009 | 2     |
      | 2010 | 2     |
      | 2011 | 2     |
      | 2012 | 2     |

  @download_statements
  Scenario Outline: Download statements
    Given user accesses the Statements & Documents tab
    And  user selects the Recent Statements Year <year>
    When  user clicks on statement "<statement>"
    Then the downloaded file name should contain "<name>"
    And the "<name>" file type should be pdf
    Examples:
      | year | statement               | name     |
      | 2009 | Statement 31/11/09(57K) | 31-11-09 |
      | 2010 | Statement 01/12/10(57K) | 01-12-10 |
      | 2011 | Statement 05/12/11(57K) | 05-12-11 |
      | 2012 | Statement 01/10/12(57K) | 01-10-12 |