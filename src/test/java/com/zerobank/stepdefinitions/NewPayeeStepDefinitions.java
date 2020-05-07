package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class NewPayeeStepDefinitions {
    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("user clicks on PayBills page")
    public void user_clicks_on_PayBills_page() {
        payBillsPage.clickPayBillsTab();
    }
    @Given("click New Payee tab")
    public void clickNewPayeeTab() {
        payBillsPage.clickAddNewPayee();
    }
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        payBillsPage.enterName(dataTable.get("Payee Name"));
        payBillsPage.enterAddress(dataTable.get("Payee Address"));
        payBillsPage.enterAccount(dataTable.get("Account"));
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        Assert.assertEquals(payBillsPage.getNewPayeeMessageCreated(),string);
    }


}
