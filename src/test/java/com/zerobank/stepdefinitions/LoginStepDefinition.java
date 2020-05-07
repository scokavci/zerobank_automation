package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

   LoginPage loginpage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @When("user logs in as authorized user")
    public void user_logs_in_as_authorized_user() {
         loginpage.clickSignIn();
         loginpage.login();
    }
    @Then("user should verify that Account summary page is displayed")
    public void user_should_verify_that_Account_summary_page_is_displayed() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals("Zero - Account Summary",Driver.getDriver().getTitle());
    }
    @When("user tries to login with invalid credentials")
    public void user_tries_to_login_with_invalid_credentials() {
        loginpage.clickSignIn();
        loginpage.login("user","pass");
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String errormessage) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals(  loginpage.getErrorText(),errormessage  );
    }






}
