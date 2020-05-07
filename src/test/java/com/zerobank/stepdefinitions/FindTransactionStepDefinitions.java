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
    public void userEntersDateRangeFromTo(String arg0, String arg1) {
     accountActivityPage.enterDateRange(arg0,arg1);
    }
    @When("clicks search")
    public void clicks_search() {
      accountActivityPage.clickSearch();
    }

    @Then("results table should only show transaction dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionDatesBetweenTo(String arg0, String arg1) {
        Assert.assertEquals(accountActivityPage.getFirstDate(), arg0);
        Assert.assertEquals(accountActivityPage.getLastDate(), arg1);
    }

    @When("user enters description {string}")
    public void user_enters_description(String string) {
       accountActivityPage.enterDescription(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
     Assert.assertTrue( accountActivityPage.getFirstTextDesc().contains(string));
     Assert.assertTrue( accountActivityPage.getlastTextDesc().contains(string));
    }
    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String arg0) {
        Assert.assertFalse(accountActivityPage.getFirstTextDesc().contains(arg0));
        Assert.assertFalse(accountActivityPage.getlastTextDesc().contains(arg0));
    }

    @Given("click {string} type")
    public void click_type(String string) {
     accountActivityPage.selectType(string);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue( accountActivityPage.verifyOneResultUnderDeposit());
    }




}
