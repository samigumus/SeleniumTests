package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MultipleButtonsTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }
    @Test
    public void verifyButton1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        String expectedResult = "Clicked on button one!";
        Assert.assertEquals(actualResult,expectedResult,"result is wrong");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
