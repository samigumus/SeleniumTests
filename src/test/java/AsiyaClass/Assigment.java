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

        if (actualTitle.equals(expectedTitle))
        {
            System.out.println("LOGIN SUCCESFULL");
        }
        else
            System.out.println("LOGIN FAILED");

        System.out.println("===============================");

        BrowserUtils.wait(2);

        /*
        driver.navigate().to("https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract");

        String contractPage = "Vehicle Contract - Entities - System - Car - Entities - System";
        String actualContractPage = driver.getTitle();

        if(actualContractPage.equals(contractPage))
        {
            System.out.println("USER SUCCESSFULL ACCESS VEHICLE CONTRACT PAGE");
        }
        else
        {
            System.out.println("USER CAN NOT ACCESS THIS PAGE");
        }

        BrowserUtils.wait(2);

         */ //TRY CONTRACT PAGE

        driver.quit();
    }

}
