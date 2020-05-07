package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(xpath="//*[@id='pay_bills_tab']")
    private WebElement pay_bills;

    @FindBy(id="sp_payee")
    private WebElement payee;

    @FindBy(id="sp_account")
    private WebElement accountType;

    @FindBy(id="sp_amount")
    private WebElement amount;

    @FindBy(id="sp_date")
    private WebElement date;

    @FindBy(id="sp_description")
    private WebElement description;

    @FindBy(id="pay_saved_payees")
    private WebElement payBtn;

    @FindBy(xpath="//*[@id='alert_content']/span")
    private WebElement message;

    @FindBy(xpath="//a[text()='Add New Payee']")
    private WebElement add_new_payee;
    @FindBy(xpath="//a[text()='Purchase Foreign Currency']")
    private WebElement purch_for_curr;

    @FindBy(xpath="//*[@id='np_new_payee_name']")
     private WebElement payee_name;

    @FindBy(id="np_new_payee_address")
    private WebElement payee_address;

    @FindBy(id="np_new_payee_account")
    private WebElement account;

    @FindBy(xpath="//div/input[@id='np_new_payee_details']")
    private WebElement details;

    @FindBy(id="alert_content")
    private WebElement newpayee_alert;

    @FindBy(id="pc_currency")
    private WebElement currency;

    @FindBy(id="pc_amount")
    private WebElement amountInCurrency;

    public void clickPayBillsTab(){

        pay_bills.click();
    }
    public void clickAddNewPayee(){
        add_new_payee.click();
        BrowserUtils.waitForPageToLoad(3);
    }
    public void clickPurchForCurr(){
        purch_for_curr.click();
        BrowserUtils.waitForPageToLoad(3);
    }
    public String getTitlePayBill(){
        pay_bills.click();
        return Driver.getDriver().getTitle();
    }
    public void verifySuccessPay(){
        Select select = new Select(payee);
        select.getFirstSelectedOption().click();
        Select select1 = new Select(accountType);
        select1.getFirstSelectedOption().click();
        amount.sendKeys("100");
        date.sendKeys("2020-05-01");
        description.sendKeys("Bill");
        payBtn.click();
    }
    public String verifySuccessMessage(){
        return message.getText();
    }

    public void incompletePay(){
        Select select = new Select(payee);
        select.getFirstSelectedOption().click();
        Select select1 = new Select(accountType);
        select1.getFirstSelectedOption().click();
        description.sendKeys("Bill");
        payBtn.click();
    }
    public String getMessage(){

        return driver.findElement(By.id("sp_amount")).getAttribute("validationMessage");
    }
    public void enterName(String value){
        wait.until(ExpectedConditions.visibilityOf(payee_name));
        payee_name.sendKeys(value,Keys.ENTER);
    }
    public void enterAddress(String value){
        wait.until(ExpectedConditions.visibilityOf(payee_address));
        payee_address.sendKeys(value,Keys.ENTER);
    }
    public void enterAccount(String value){
        wait.until(ExpectedConditions.visibilityOf(account));
        account.sendKeys(value,Keys.ENTER);
    }
    public String getNewPayeeMessageCreated(){
        return newpayee_alert.getText();
    }


    public List<String> getCurrencyOptions(){
        wait.until(ExpectedConditions.visibilityOf(currency));
        Select select = new Select(currency);
        List<WebElement> currency_options = select.getOptions();
        return BrowserUtils.getTextFromWebElements(currency_options);
    }
    public void sendOnlyAmount(){
        amountInCurrency.sendKeys("10",Keys.ENTER);
    }
    public String getErrorMessage(){
      return driver.switchTo().alert().getText();
    }
    public void notSendAmount(){
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pc_calculate_costs']"))).click();
    }
}
