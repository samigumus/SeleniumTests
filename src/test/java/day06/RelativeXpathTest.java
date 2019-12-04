package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class RelativeXpathTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.navigate().to("https://login1.nextbasecrm.com/");
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        //relative xpath
        WebElement warningMas = driver.findElement(By.xpath("//div[@class='errortext']"));
        System.out.println(warningMas.getText());
        driver.quit();
    }
}
