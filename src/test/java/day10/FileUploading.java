package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;
import utils.StringCompare;

public class FileUploading {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @Test(description = "file upload")
    public void test1() {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/ASG/Desktop/debug.log");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
        String expectFile = "debug.log";
        String actualFile = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println(StringCompare.verifyEquals(actualFile, expectFile));
        Assert.assertEquals(actualFile,expectFile);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
