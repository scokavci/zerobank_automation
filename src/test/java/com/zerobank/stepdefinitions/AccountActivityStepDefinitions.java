package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {
      AccountActivityPage account_activity_page = new AccountActivityPage();

    @Then("user verify the title of Account Activity Page as {string}")
    public void user_verify_the_title_of_Account_Activity_Page_as(String string) {
        Assert.assertEquals(  account_activity_page.getTitleAccountActivity(), string  );
    }

    @Then("view default option as {string} in the Account drop down")
    public void view_default_option_as_in_the_Account_drop_down(String string) {
       Assert.assertEquals(account_activity_page.getSelectedDefault(),string);
    }

    @Then("view dropdown options in the Account should have following options")
    public void view_dropdown_options_in_the_Account_should_have_following_options(List<String> dataTable) {
        Assert.assertEquals(account_activity_page.getAllOptionsInDropdown(),dataTable);
    }

    @Then("view transactions table column names should have the following options")
    public void view_transactions_table_column_names_should_have_the_following_options(List<String> dataTable) {
      Assert.assertEquals(account_activity_page.getTransactionColumnNames(),dataTable);
    }


}
