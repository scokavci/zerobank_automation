package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OnlineStatementsPage extends BasePage {

   @FindBy(xpath="//*[@id='online_statements_tab']")
    private WebElement online_statement;

   public void clickOnlineTab(){
       online_statement.click();
   }
   public void selectYear(Integer int1){
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+int1+"']"))).click();
   }
   @FindBy(xpath = "//table/tbody/tr[1]/td[1]/a")
   private List<WebElement> statements;

   public int numberStatementDisplayed(){
       List<WebElement> TotalRowsList = driver.findElements(By.xpath("//*[@id='os_2009']/table/tbody/tr/td[1]/a"));
       return TotalRowsList.size();
   }

   public void clickStatement(String string){
       WebElement firstRow = driver.findElement(By.xpath("//a[contains(text(),'"+string+"']"));
       wait.until(ExpectedConditions.elementToBeClickable(firstRow)).click();
   }
   public String getStatementName(String string){
       WebElement firstRow = driver.findElement(By.xpath("//a[text()='"+string+"']"));
       wait.until(ExpectedConditions.visibilityOf(firstRow));
       return firstRow.getText();
   }

   public String fileNameAndType(String string){
       WebElement name = driver.findElement(By.xpath("//a[@href='/bank/online-statements-by-name.html?name=8534567-"+string+".pdf']"));
       return name.getText();
   }
}
