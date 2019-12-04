package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCh {

    public static void main(String[] args) {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        //create an object of appropriate
        ChromeDriver driver = new ChromeDriver();
        //open url  .get()
        driver.get("http://google.com");

        // read page title,  .getTitle()
        String actualResult = driver.getTitle();
        String expectedResult = "Google";

            if(actualResult.equals(expectedResult))
            {
                System.out.println("Test passed"); // shortcut print "sout"
            }
            else
            {
                System.out.println("Test failed");
            }


        //end of the test execution we have to close it
        //to close browser
        driver.close();
    }
}
