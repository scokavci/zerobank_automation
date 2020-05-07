package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("user verify the title of Pay Bills Page as {string}")
    public void user_verify_the_title_of_Pay_Bills_Page_as(String string) {
        Assert.assertEquals(payBillsPage.getTitlePayBill(), string);
    }

    @When("user completes a Successful Pay operation")
    public void user_completes_a_Successful_Pay_operation() {
        payBillsPage.verifySuccessPay();
    }

    @Then("user verify {string} message should be displayed")
    public void user_verify_message_should_be_displayed(String string) {
       Assert.assertEquals( payBillsPage.verifySuccessMessage(),string);
    }

    @When("user tries to make payment without entering {string} or {string}")
    public void user_tries_to_make_payment_without_entering_or(String amount, String date) {
        payBillsPage.incompletePay();
    }

    @Then("user view {string} message should be displayed")
    public void user_view_message_should_be_displayed(String string) {
     Assert.assertEquals(payBillsPage.getMessage(),string);
    }





}
