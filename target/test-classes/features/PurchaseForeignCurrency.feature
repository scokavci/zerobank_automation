Feature: Purchase Foreign Currency

  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user
    And user clicks on PayBills page

   @available_currency
  Scenario: Available currencies
    Given user accesses Purchase foreign currency cash tab
    Then following currencies should be available
      | Select One            |
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      |Hong Kong (dollar)     |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      |Sweden (krona)         |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  @not_select_currency
  Scenario: Error message for not selecting currency
    Given user accesses Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @not_enter_amount
  Scenario: Error message for not entering value
    Given user accesses Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed