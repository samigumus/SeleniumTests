package day03;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        //to maximize browser window
        driver.manage().window().maximize();
        driver.get("http://google.com");
        //page title print
        System.out.println(driver.getTitle());

        //wait for 3 sec
        //this is our custom method
        //method is static, using class name the mthod
        //parameter, we provide number of second
        BrowserUtils.wait(5);

        driver.navigate().to("http://amazon.com");
        //navigate back to google (previous URL)
        driver.navigate().back();
        //move forward to the amazon again
        driver.navigate().forward();
        //to refresh/reload a webpage/website
        driver.navigate().refresh();
        //title page
        System.out.println(driver.getTitle());

        driver.quit();
        //after quit we can't use driver
        //if we have more than 2 tab and we are use .close() we can continue
    }
}
