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

   LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("user logs in as authorized user")
    public void user_logs_in_as_authorized_user() {
         loginPage.login();
    }
    @When("users try to log in with invalid username {string}")
    public void users_try_to_log_in_with_invalid_username(String string) {
        loginPage.login(string,ConfigurationReader.getProperty("password"));
    }
    @When("users try to log in with invalid password {string}")
    public void users_try_to_log_in_with_invalid_password(String string) {
        loginPage.login(ConfigurationReader.getProperty("username"),string);
    }

    @When("users try to log in with blank user name")
    public void users_try_to_log_in_with_blank_user_name() {
        loginPage.login("",ConfigurationReader.getProperty("password"));
    }
    @When("users try to log in with blank password")
    public void users_try_to_log_in_with_blank_password() {
        loginPage.login(ConfigurationReader.getProperty("username"),"");
    }
    @Then("user should verify that title is {string}")
    public void user_should_verify_that_title_is(String string) {
        Assert.assertEquals(string,Driver.getDriver().getTitle());
    }

    @Then("user should verify that error message is {string}")
    public void user_should_verify_that_error_message_is(String string) {
        Assert.assertEquals(string,loginPage.getErrorText());
    }



}
