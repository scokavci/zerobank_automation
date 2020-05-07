package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(xpath="//*[@id='account_activity_tab']")
    private WebElement account_activity;

    @FindBy(id="aa_accountId")
    private WebElement accountDropdown;

    @FindBy(xpath="//table//tr[1]//th")
    private List<WebElement> tableHead;

    @FindBy(css="[href='#ui-tabs-2']")
    private WebElement find_trans;

    @FindBy(id="aa_description")
    private WebElement description;

    @FindBy(id="aa_fromDate")
    private WebElement fromDate;

    @FindBy(id="aa_toDate")
    private WebElement toDate;

    @FindBy(id="aa_fromAmount")
    private WebElement fromAmount;

    @FindBy(id="aa_toAmount")
    private WebElement toAmount;

    @FindBy(id="aa_type")
    private WebElement type;

    @FindBy(css="[type='submit']")
    private WebElement findBtn;

    @FindBy(xpath="(//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1])[1]")
    private WebElement dateLast;

    @FindBy(xpath="(//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1])[3]")
    private WebElement dateFirst;


    public String getTitleAccountActivity(){
        account_activity.click();
        return Driver.getDriver().getTitle();
    }
    public String getSelectedDefault(){
        Select select = new Select(accountDropdown);
        return select.getFirstSelectedOption().getText();
    }
    public List<String> getAllOptionsInDropdown(){
        Select select = new Select(accountDropdown);
        List<WebElement> dropdown_options = select.getOptions();
        BrowserUtils.wait(5);
        return BrowserUtils.getTextFromWebElements(dropdown_options);
    }

    public List<String> getTransactionColumnNames(){
         return BrowserUtils.getTextFromWebElements(tableHead);
    }
    public void clickAccountActivity(){
        account_activity.click();
    }
    public void clickFindTransTab(){
        find_trans.click();
    }

    public void enterDateRange(String date1, String date2){
        BrowserUtils.wait(3);
        fromDate.sendKeys(date1,Keys.ENTER);
        toDate.sendKeys(date2,Keys.ENTER);
    }
    public void clickSearch(){
        BrowserUtils.wait(2);
        findBtn.click();
    }
    public String getFirstDate(){
        BrowserUtils.wait(4);
        return dateFirst.getText();
    }
    public String getLastDate(){
        BrowserUtils.wait(4);
        return dateLast.getText();
    }
    public void enterDescription(String dsc){
        BrowserUtils.wait(4);
        description.sendKeys(dsc,Keys.ENTER);
    }

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr[1]/td[2]")
    private WebElement desc1;
    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr[2]/td[2]")
    private WebElement desc2;

    public String getFirstTextDesc() {
        return desc1.getText();
    }
    public String getlastTextDesc() {
        BrowserUtils.wait(5);
        return desc2.getText();
    }
    public void selectType(String string){
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("aa_type"))));
        Select select = new Select(type);
        select.selectByVisibleText(string);
        clickSearch();
    }

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']//tbody/tr[1]/td[3])")
    private WebElement deposit;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']//tbody/tr[1]/td[4])")
    private WebElement withdrawal;

    public boolean verifyOneResultUnderDeposit(){
         WebElement depositel =driver.findElement(By.xpath("(//table//tbody/tr/td[3])[1]"));
      return  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//table//tbody/tr/td[3])[1]"))).isDisplayed();

    }

    public String verifyOneResultWithdrawal(){
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.visibilityOf(withdrawal));
        return withdrawal.getText();
    }


}
