package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatementsPage;
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
    @When("user selects the Recent Statements Year {int}")
    public void user_selects_the_Recent_Statements_Year(Integer int1) {
     onlineStatementsPage.selectYear(int1);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(int int1) {
        Assert.assertEquals(onlineStatementsPage.numberStatementDisplayed(), int1);
    }
    @When("user clicks on statement {string}")
    public void user_clicks_on_statement(String string) {
       onlineStatementsPage.clickStatement(string);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
       Assert.assertTrue( onlineStatementsPage.getStatementName(string).contains(string) );
    }

    @Then("the {string} file type should be pdf")
    public void the_file_type_should_be_pdf(String string) {
     Assert.assertTrue( onlineStatementsPage.fileNameAndType(string).contains(".pdf"));
    }

    @Then("<count> statements should be displayed for that year")
    public void countStatementsShouldBeDisplayedForThatYear() {
    }
}
