package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementTest {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //after we opened the page catch the title
        String expectedTitle = driver.getTitle();
        // to find element on web site ( in chrome inspector and find locator)
        // create object of WebElement
        // use WebElement
        WebElement button = driver.findElement(By.id("form_submit"));
        // to click the element
        button.click();
        //read title again, after clicking
        String actualTitle = driver.getTitle();
        //after click compare the page title
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected title: "+expectedTitle);
            System.out.println("Actual title: "+actualTitle);
        }
        BrowserUtils.wait(3);
        driver.close();

    }
}
