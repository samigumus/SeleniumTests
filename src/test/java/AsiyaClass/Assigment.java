package AsiyaClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Assigment {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa2.vytrack.com/user/login");

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("storemanager213");

        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

        BrowserUtils.wait(2);

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        BrowserUtils.wait(2);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("LOGIN SUCCESFULL");
        } else
            System.out.println("LOGIN FAILED");

        System.out.println("===============================");

        BrowserUtils.wait(2);

        driver.quit();
    }

}
