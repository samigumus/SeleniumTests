package day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Dropdowns {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1() {

        // to work with select dropdowns, we need to use Select class in Selenium
        //step 1. Find dropdown and create a web element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //ste 2. Create a select object
        //select class requires web element object as a parameter
        Select select = new Select(dropdown);
        //to select any option by visible text:
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        // verify selecting option
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");

    }

    @Test(description = "select date")
    public void test2(){

        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1994");

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("March");

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("30");

        BrowserUtils.wait(3);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}