@smoke_test
Feature: Pay Bills
  As a user complete a successful pay operation, then verify display message
  As a user verify display error message after incomplete pay operation

  Background: user is on login page
    Given user is on the login page
    And user logs in as authorized user
    Then user verify the title of Pay Bills Page as "Zero - Pay Bills"

  @successful_payment
  Scenario:Completes a successful pay
    When user completes a Successful Pay operation
    Then user verify "The payment was successfully submitted." message should be displayed

  @incomplete_payment
  Scenario: Missing date and amount in payment process
    When user tries to make payment without entering "amount" or "date"
    Then user view "Please fill out this field." message should be displayed
