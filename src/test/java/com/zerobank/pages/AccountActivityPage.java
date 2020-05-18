package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Collections;
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
    /**
     * This method checks the date range from listed table
     *
     * @return true if it is in the range
     * false if it is not in the range
     * <p>
     * List<String> dates has data: {"2012-09-06","2012-09-05","2012-09-01"}
     */
    public boolean isItInTheRange(String from, String to, List<String> dates) {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        for (String date : dates) {
            LocalDate scrappedDate = LocalDate.parse(date);
            if (!(fromDate.isBefore(scrappedDate) || fromDate.isEqual(scrappedDate))) {
                System.out.println(fromDate + " is not before or equal " + scrappedDate);
                return false;
            } else if (!(toDate.isAfter(scrappedDate) || toDate.isEqual(scrappedDate))) {
                System.out.println(fromDate + " is not before or equal " + scrappedDate);
                return false;
            }

        }
        return true;
    }
    /**
     * Get all data as String list from defined column name.
     * It checks table header index and depends on that index, collects that column data
     *
     * @return data as List<String>
     */
    public List<String> getDataFromTable(String columnName) {
        String columnNumber = "";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("filtered_transactions_for_account"))));

        List<WebElement> title = driver.findElements(By.xpath("//div[@id='filtered_transactions_for_account']//th"));
        for (WebElement e : title) {
            if (e.getText().equals(columnName)) {
                columnNumber = String.valueOf(title.indexOf(e) + 1);
                break;
            }
        }

        if(columnNumber.equals("")){ //if the table column doesn't exist
            return Collections.emptyList();
        }

        return BrowserUtils.getTextFromWebElements(
                driver.findElements(By.xpath("//div[@id=\"filtered_transactions_for_account\"]//td[" + columnNumber + "]")));

    }

    /**
     * This method help you to check whether they are sorted or not
     *
     * @param dates List<String> dates has data: {"2012-09-06","2012-09-05","2012-09-01"}
     * @return true if it is ordered as most recent date to old date exp: {"2012-09-06","2012-09-05","2012-09-01"}
     * false if it is not ordered as the most recent date to old date exp: {"2012-09-01","2012-09-05","2012-09-09"}
     */
    public boolean isItSortedRecentToOld(List<String> dates) {
        LocalDate tmpDate = LocalDate.parse(dates.get(0));
        for (int i = 0; i < dates.size(); i++) {
            LocalDate scrappedDate = LocalDate.parse(dates.get(i));
            if (!(tmpDate.isEqual(scrappedDate) || tmpDate.isAfter(scrappedDate))) {
                return false;
            }
            tmpDate = scrappedDate;
        }
        return true;
    }

    /**
     * This method check that is data included in the list or not.
     *
     * @param data   searched data
     * @param column listed/stored data
     * @return true if data in the list
     * false if data not in the list
     * NOT: this method check whether a single data appear one time in the list
     */
    public boolean isDateListed(String data, List<String> column) {
        return column.contains(data);
    }
    public void enterDescription(String string){
        BrowserUtils.wait(4);
        description.sendKeys(string,Keys.ENTER);
    }
    /**
     * This method checks the list that contains specific data or not.
     *
     * @param value  searched value
     * @param column listed/stored data
     * @return true if data in the list
     * false if data not in the list
     * NOT: This method searches a value in every String, if the value doesn't exist in a String, returns false
     * This is for checking Description column
     */
    public boolean isDataListed(String value, List<String> column) {
        if (!isDataListed(column)) {
            return false; // if table doesn't return anything with correct data, return false
        }
        for (String data : column) {
            if (!data.contains(value)) {
                return false;
            }

        }
        return true;
    }

    public boolean isDataListed(List<String> column) {
        return column.size() != 0; // if table doesn't return anything data, returns false
    }

    /**
     * Helps you to select from designated drop down
     * @param selectElementName accepts Element ID
     */
    public void selectFrom(String selectElementName, String string){
        Select select = new Select(driver.findElement(By.name(selectElementName)));
        select.selectByVisibleText(string);
    }

}
