package desktops;
// **** Created By Harshit Patel ****

import homepage.utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElement(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));

        //1.2 Click on “Show All Desktops”
        mouseHoverToElementAndClick(By.linkText("Show All Desktops"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        String expText = "Name (Z - A)";
        String actText = getTextFromElement(By.xpath("//select/option[contains(text(), 'Name (Z - A)')]"));
        Assert.assertEquals("Not Matching", expText, actText);
    }

    @Test

    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElement(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));

        //2.2 Click on “Show All Desktops”
        mouseHoverToElementAndClick(By.linkText("Show All Desktops"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("NotMatching", expectedText, actualText);

        //2.6 Select Delivery Date "2022-11-30"
        String monthAndYear = "November 2022";
        String day = "30";
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));


        while (true) {
            String monYear = getTextFromElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]"));
            if (monYear.equalsIgnoreCase(monthAndYear)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr/td[contains(text(), '" + day + "')]"));

        //2.7.Enter Qty "1” using Select class. -- There is no Dropdown menu to choose from.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expMessageS = "Success: You have added HP LP3065 to your shopping cart!";
        String actMessageS = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 56);
        Assert.assertEquals("Not correct text", expMessageS, actMessageS);

        Thread.sleep(5000);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        String expMessage1 = "Shopping Cart";
        String actMessage1 = getTextFromElement(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13);
        Assert.assertEquals("Not correct text", expMessage1, actMessage1);

        //2.12 Verify the Product name "HP LP3065"

        String expProductName = "HP LP3065";
        String actProductName = getTextFromElement(By.xpath("(//a[text()='HP LP3065'])[2]"));
        Assert.assertEquals("Not correct text", expProductName, actProductName);

        //2.13 Verify the Delivery Date "2022-11-30"
        String expTextDate = "2022-11-30";
        String actTextDate = getTextFromElement(By.xpath("(//small[contains(text(), '2022-11-30')])[2]")).substring(15, 25);
        Assert.assertEquals("Not correct Text", expTextDate, actTextDate);
        //assertAssert("Not Matching", expTextDate, actTextDate);

        //2.14 Verify the Model "Product21"
        String expTextModel = "Product 21";
        String actTextModel = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Not correct Text", expTextModel, actTextModel);

        //assertAssert("Not Matching", expTextModel, actTextModel);

        //2.15 Verify the Todat "£74.73"
        clickOnElement(By.xpath("//form[@id='form-currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
        String expTextTotal = "£74.73";
        String actTextTotal = getTextFromElement(By.xpath("(//td[@class='text-right' and text()='£74.73'])[5]"));
        Assert.assertEquals("Not Matching", expTextTotal, actTextTotal);

    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
