package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    LoginPage loginPage = new LoginPage();

    @When("user clicks on {string} link on the Account Summary page")
    public void user_clicks_on_link_on_the_Account_Summary_page(String string) {
        accountSummaryPage.clickLinks(string);
    }

    @Then("Account Activity page should be displayed")
    public void account_Activity_page_should_be_displayed() {
       Assert.assertTrue( accountSummaryPage.accountActivityPageDisplay() );
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
       Assert.assertEquals( accountSummaryPage.getSelectedDefault(),string);
    }
    @Then("logout")
    public void logout() {
        accountSummaryPage.logOut();
    }



}
