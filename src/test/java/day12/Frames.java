package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Frames {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @Test
    public void test01() {
        driver.findElement(By.linkText("iFrame")).click();
        //element inside the frame it is not visible, switching to frame
        driver.switchTo().frame("mce_0_ifr");
        //without switch, we can not see inner HTML document
        WebElement inputArea = driver.findElement(By.id("tinymce"));

        String expectedText = "Your content goes here.";
        String actualtext = inputArea.getText();
        Assert.assertEquals(actualtext, expectedText);

        BrowserUtils.wait(2);
        inputArea.clear();
        inputArea.sendKeys("Java is fun");
        BrowserUtils.wait(3);
        //exit to frame
        driver.switchTo().defaultContent();
    }

    @Test(description = "nested frames example")
    public void test02() {
        driver.findElement(By.linkText("Nested Frames")).click();
        WebElement bottom = driver.findElement(By.cssSelector("[name='frame-bottom']"));
        driver.switchTo().frame(bottom);
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());
        //back to default
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
