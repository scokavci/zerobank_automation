package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="signin_button")
    private WebElement signInBtn;

    @FindBy(id="user_login")
    private WebElement user_login;

    @FindBy(id="user_password")
    private WebElement user_password;

    @FindBy(css="[class='alert alert-error']")
    private WebElement error;

    @FindBy(xpath = "//div[contains(text(),\"Login and/or password are wrong\")]")
    private WebElement errorMessage;

    public void login(String usernameValue, String passwordValue){
        signInBtn.click();
        BrowserUtils.waitForPageToLoad(10);
        user_login.sendKeys(usernameValue);
        user_password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
    }

    public void login() {
        signInBtn.click();
        BrowserUtils.waitForPageToLoad(10);
        user_login.sendKeys(ConfigurationReader.getProperty("username"));
        user_password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
    }

    public String getErrorText(){
       return errorMessage.getText().trim();
    }


}
