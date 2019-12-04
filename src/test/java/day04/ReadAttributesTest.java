package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ReadAttributesTest {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        //read any attribute
        //name "email" name it's a attribute, email it's a value of attribute
        System.out.println("pattern is: "+input.getAttribute("pattern"));
        input.sendKeys("random@email.com");
        //read entered text
        //it is gonna be inside value attribute
        System.out.println(input.getAttribute("value"));
        //if button type is "submit"
        //we can use .submit() method intead of .click()
        WebElement button = driver.findElement(By.id("form_submit"));
        //alternative to click, if only type="submit"
        button.submit();

        BrowserUtils.wait(2);
        driver.close();

    }
}
