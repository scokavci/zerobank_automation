package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id="signin_button")
    private WebElement signInBtn;

    @FindBy(id="user_login")
    private WebElement user_login;

    @FindBy(id="user_password")
    private WebElement user_password;

    @FindBy(css="[class='alert alert-error']")
    private WebElement error;


    public void clickSignIn(){
        BrowserUtils.wait(5);
        signInBtn.click();
    }
    public void login() {
      user_login.sendKeys(ConfigurationReader.getProperty("username"));
      user_password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
      BrowserUtils.waitForPageToLoad(10);
      BrowserUtils.wait(5);
    }
    public void login(String usernameValue, String passwordValue){
      user_login.sendKeys(usernameValue);
      user_password.sendKeys(passwordValue,Keys.ENTER);
      BrowserUtils.waitForPageToLoad(10);
      BrowserUtils.wait(5);
    }

    public String getErrorText(){
       return error.getText();
    }


}
