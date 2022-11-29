package homepage.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    /**
     * This Method will click on any find element
     */

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This Method will send text find element
     */
    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        //type email to email field.
        emailField.sendKeys(text);
    }

    /**
     * This Method will get text from element
     */
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //This method will switch to Alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
            }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys("text");
    }


    // ************* Select Class Methods ***********************


    /**
     * This method will select options by visible text from dropdown menu
     */

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Visible Text
        select.selectByVisibleText(text); // this will select value from country field.
    }

    /**
     * This method will select options by value from dropdown menu
     */

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Value
        select.selectByValue(text); // this will select value from country field.
    }

    /**
     * This method will select options by Index from dropdown menu
     */

    public void selectByIndexFromDropDown(By by, int ind) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Index
        select.selectByIndex(ind); // this will select value from country field.
    }

    /**
     * This method will select options by contain text from dropdown menu
     */

    public void selectByContainsTextFromDropDown(By by) {
        WebElement dropDown = driver.findElement(by);
        // Creating an object of Select class which is parameterised so pass dropDown
        Select select = new Select(dropDown);
        //Select by Contain Text
        List<WebElement> list = select.getOptions(); // this will select value from country field.
    }

    // This method hoover on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }

    // This method hoover on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }


}
