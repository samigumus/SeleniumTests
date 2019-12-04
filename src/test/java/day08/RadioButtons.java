package day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    // ctrl + alt + L organize codes

    private WebDriver driver; // cause of we want to use only this class

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        //to click Radio Buttons link and go to page
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "blue button selected")
    public void test1() {

        WebElement blueButton = driver.findElement(By.id("blue"));
        boolean isSelected = blueButton.isSelected();
        Assert.assertTrue(isSelected);
    }

    @Test(description = "verify red button is not selcted")
    public void test2() {
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());
    }

    @Test(description = "verify green button is not clickable")
    public void test3() {
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }

    @Test(description = "click all radio buttons")
    public void test4() {

        //find all radio buttons
        //any radio button will have type='radio' and input as a element type
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

        for (WebElement button : radioButtons) {
            //if button is avaible for clicking and not click yet
            if (button.isEnabled() && !button.isSelected()) {
                //then click each one
                button.click();
                // name of button
                System.out.println("Button is clicked: " + button.getAttribute("id"));
            } else {
                System.out.println("Button is not clicked: " + button.getAttribute("id"));
            }
            BrowserUtils.wait(1);
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
