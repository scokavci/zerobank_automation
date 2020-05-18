package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatementsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocumentsStepDefinitions {
    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();

    @Given("user accesses the Statements & Documents tab")
    public void user_accesses_the_Statements_Documents_tab() {
        onlineStatementsPage.clickOnlineTab();
    }

    @When("user selects the Recent Statements Year {string}")
    public void userSelectsTheRecentStatementsYear(String arg0) {
        onlineStatementsPage.selectYear(arg0);
    }

    @Then("{string} statements {string} should be displayed for that year")
    public void statementsShouldBeDisplayedForThatYear(String arg0, String arg1) {
        Assert.assertTrue(  onlineStatementsPage.statementAndCountDisplayed(arg0,arg1) );
    }
    @When("user clicks on statement {string}")
    public void user_clicks_on_statement(String string) {
        onlineStatementsPage.clickStatement(string);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        Assert.assertTrue(onlineStatementsPage.isDownloaded(string));
    }

    @And("the file type should be pdf")
    public void theFileTypeShouldBePdf() {
        Assert.assertTrue(onlineStatementsPage.isDownloadedTypePDF("pdf"));
    }


}
