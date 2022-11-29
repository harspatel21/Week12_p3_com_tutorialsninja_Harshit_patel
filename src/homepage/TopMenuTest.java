package homepage;
// **** Created By Harshit Patel ****

import homepage.utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //created method with one parameter name "menu".
    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");

        //1.3 Verify the text ‘Desktops'
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals("NotMatching", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals("NotMatching", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.linkText("Components"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");

        //3.3 Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals("NotMatching", expectedText, actualText);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
