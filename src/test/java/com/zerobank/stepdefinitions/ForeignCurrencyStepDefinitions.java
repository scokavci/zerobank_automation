package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ForeignCurrencyStepDefinitions {
     PayBillsPage payBillsPage = new PayBillsPage();

    @Given("user accesses Purchase foreign currency cash tab")
    public void user_accesses_Purchase_foreign_currency_cash_tab() {
       payBillsPage.clickPurchForCurr();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Assert.assertEquals(payBillsPage.getCurrencyOptions(), dataTable);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
      payBillsPage.clickPurchForCurr();
      payBillsPage.sendOnlyAmount();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertFalse( payBillsPage.getErrorMessage().isEmpty());
    }
    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.notSendAmount();
    }



}
