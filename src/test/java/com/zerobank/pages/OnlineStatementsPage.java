package com.zerobank.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class OnlineStatementsPage extends BasePage {

   @FindBy(xpath="//*[@id='online_statements_tab']")
   private WebElement online_statement;
   @FindBy(xpath = "//table/tbody/tr[1]/td[1]/a")
   private List<WebElement> statements;

   private String fileName;

   public void clickOnlineTab(){
       online_statement.click();
   }
   public void selectYear(String arg0){
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+arg0+"']"))).click();
   }
    /**
     * This method finds statements amount searched year and verified with count
     *
     * @param year  statement year
     * @param count amount of statement from example table
     * @return true if count and displayed statement amount same
     * false if count and displayed statement amount not same
     */
   public boolean statementAndCountDisplayed(String year, String count){
       return driver.findElements(By.xpath("//*[@id='os_"+ year+"']//a")).size() == Integer.parseInt(count);
   }

   public void clickStatement(String string){
       wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(string)));
       driver.findElement(By.linkText(string)).click();
   }

    /**
     * This methods verifies download process.
     * @param fileName searched file
     * @return true if file exist in local directory
     *          false if file doesn't exist in local directory
     */
    public boolean isDownloaded(String fileName) {
        this.fileName=fileName;
        String file=findFile(this.fileName);
        return file != null;
    }

    /**
     * Search local download directory and return searched file full name if exist
     * @param fileName searched file name. Full or partial.
     * @return full file name as string. (including file type)
     *         if file doesn't exist return null
     */

    public String findFile(String fileName){
        try {
            File folder = new File("C:/Users/Lenovo/Downloads/");
            File[] files=folder.listFiles();
            assert files != null;
            for (File file : files) {
                if(file.getName().contains(fileName)){
                    return file.getName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method verifies downloaded file type
     * @param format searched format
     * @return true if file name contains searched format type
     *          false if file name doesn't contain searched format type
     */
    public boolean isDownloadedTypePDF(String format){
        String file=findFile(fileName);
        return file.contains(format);
    }
}
