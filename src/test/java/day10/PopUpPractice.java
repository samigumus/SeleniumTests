package day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @Test
    public void test1() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]")).click();
        BrowserUtils.wait(2);
        //to deal with popup, create Alert obj then switch
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")).getText());
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")).getText());

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
