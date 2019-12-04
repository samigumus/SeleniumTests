package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDrop {
    private WebDriver driver;

    @Test
    public void test1() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        //click on accept cookies
        BrowserUtils.wait(3);//for demo
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();

        Actions action = new Actions(driver);

        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));

        BrowserUtils.wait(3);

//      * @param source element to emulate button down at.
//      * @param target element to move to and release the mouse at.
        action.dragAndDrop(moon,earth).pause(2000).perform();

        BrowserUtils.wait(3);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
