package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        // or we can use [class='btn btn-primary']
        // . mean class name
        // # mean id
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));

       for(WebElement button : buttons) {
           //click one by one
           button.click();
           BrowserUtils.wait(1);
           WebElement message = driver.findElement(By.cssSelector("#result"));
           System.out.println(message.getText());
       }

        driver.quit();
    }
}
