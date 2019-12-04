package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {

    @Test
    public void test(){
        //verify expected and actual result is the same
        //if no - stop the program and throw exception
                            //actual   //expected          //message
        Assert.assertEquals("appl","apple","word isn't correct");

    }
    @Test(description = "verify title practice website")
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        String expected = "Practice";
        String actual = driver.getTitle();
        Assert.assertEquals(actual,expected,"Title is wrong");
        driver.quit();
    }

    @Test(description = "verify heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
                                                //other   //span[@class='h1y']
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        //assertTrue - method checks if is true
        //.isDisplayed() - return true or false
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");
        driver.quit();
    }
}
