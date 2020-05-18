package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class FindTransactionStepDefinitions {
     AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("user logs in Account Activity page")
    public void user_logs_in_Account_Activity_page() {
        accountActivityPage.clickAccountActivity();
    }
    @Given("user access Find Transactions tab")
    public void userAccessFindTransactionsTab() {
        accountActivityPage.clickFindTransTab();
    }

    @When("user enters date range from {string} to {string}")
    public void user_enters_date_range_from_to(String string, String string2) {
        accountActivityPage.enterDateRange(string,string2);
    }
    @Then("user should complete process with {string} button")
    public void user_should_complete_process_with_button(String string) {
        accountActivityPage.clickSearch();
    }
    @Then("results table should only show transaction dates between {string} to {string}")
    public void results_table_should_only_show_transaction_dates_between_to(String string, String string2) {
       Assert.assertTrue(  accountActivityPage.isItInTheRange(string,string2, accountActivityPage.getDataFromTable("Date")));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
     Assert.assertTrue(   accountActivityPage.isItSortedRecentToOld(accountActivityPage.getDataFromTable("Date"))  );
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
       Assert.assertFalse(accountActivityPage.isDateListed(string,accountActivityPage.getDataFromTable("Date")));
    }

    @When("user enters description {string}")
    public void user_enters_description(String string) {
        accountActivityPage.enterDescription(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(accountActivityPage.isDataListed(string, accountActivityPage.getDataFromTable("Description")));
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        Assert.assertFalse(accountActivityPage.isDataListed(string,accountActivityPage.getDataFromTable("Description")));
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        Assert.assertTrue(accountActivityPage.isDataListed(accountActivityPage.getDataFromTable(string)));
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        accountActivityPage.selectFrom("type",string);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        Assert.assertTrue(accountActivityPage.isDataListed(accountActivityPage.getDataFromTable(string)));
    }

}





