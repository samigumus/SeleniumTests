package AsiyaClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;
import utils.StringCompare;

public class Asignment2 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa2.vytrack.com/user/login");

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("storemanager213");

        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("aaaa11111", Keys.ENTER);

        BrowserUtils.wait(2);
        //relative xpath
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']"));

        String actualMsg = actualMessage.getText();
        //System.out.println(actualMsg);

        String expectedMsg = "Invalid user name or password.";

        String result = StringCompare.verifyEquals(actualMsg, expectedMsg);

        System.out.println(result);

        driver.close();
    }
}
