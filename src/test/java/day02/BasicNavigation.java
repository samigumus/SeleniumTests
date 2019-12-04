package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //to maximize browser screen
        driver.manage().window().maximize();

        driver.get("http://google.com");

        //navigate different page
        driver.navigate().to("http://amazon.com");
        //previous page
        driver.navigate().back();
        //return current URl string
        String url = driver.getCurrentUrl();
        System.out.println("page url is : "+url);

        //close method just close 1 tab
        //driver.close();

        //selenium cannot close browser automatically
        driver.quit();

    }
}
