package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AccountSummaryPage extends BasePage {

    @FindBy(id="aa_accountId")
    private WebElement accountDropdown;

    @FindBy(xpath="//*[@id='account_activity_tab']")
    private WebElement account_activity;

    @FindBy(id="account_summary_tab")
    private WebElement account_summary;

    @FindBy(xpath="//*[@id='settingsBox']/ul/li[3]/a")
    private WebElement usernameBox;

    @FindBy(id="logout_link")
    private WebElement logout;

    public void clickLinks(String link_name){
        String link = "(//*[text()='"+link_name+"'])[1]";
        WebElement linkXpath = driver.findElement(By.xpath(link));
        linkXpath.click();
    }
    public boolean accountActivityPageDisplay(){
       return  account_activity.isDisplayed();
    }

    public String getSelectedDefault(){
        BrowserUtils.waitForPageToLoad(6);
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(accountDropdown)));
        return select.getFirstSelectedOption().getText();
    }
    public void logOut(){
        usernameBox.click();
        logout.click();
    }

}
