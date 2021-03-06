package com.zerobank.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /**
     *
     * @param seconds
     * @throws InterruptedException
     */

    public static void wait(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param elements
     * @return List<String>
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textvalues = new ArrayList<>();
        for (WebElement element : elements) {
              textvalues.add(element.getText());
        }
        return textvalues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds){
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot(String name) {
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        String path = "";
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }
        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        try {
            //copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * This method will switch webdriver from current window
     * to target window based on page title
     * @param title of the window to switch
     */
    public static void switchWindow(String title){
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for(String window : windowHandles){
            Driver.getDriver().switchTo().window(window);
            if(Driver.getDriver().getTitle().equals(title)){
                break;
            }
        }
    }

}
