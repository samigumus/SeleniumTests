package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class NewTab {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");

    }

    @Test(description = "jump to new tab")
    public void test1() {
        driver.findElement(By.linkText("New tab")).click();
        System.out.println(driver.getTitle());
        BrowserUtils.wait(5);

        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");
        //in selenium every window has id. that id calls window handle
        //to read window handle we use method getWindowHandle()
        //save original window id
        String oldWindow = driver.getWindowHandle();
        //list - it's a data structure
        //set - also data structure, but it doesn't allow duplicates only unique values
        //we can easily access, there is no .get() method
        //we need to loop through the set
        //to get all windows/tabs id/handles list
        Set<String> windowHandles = driver.getWindowHandles();
        // loop for collection of window handles
        for (String windowHandle : windowHandles) {
            //if it's not an old window
            if (!windowHandle.equals((oldWindow))) {
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("Title is: " + driver.getTitle());

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/p/strong"));
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "New tab title is wrong");

    }

    @Test
    public void test2() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
