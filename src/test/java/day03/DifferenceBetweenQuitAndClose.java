package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitAndClose {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);//will pause execution for 4 seconds

        //close method just close 1 tab
        //driver.close();

        //selenium cannot close browser automatically
        driver.quit();  //to shutdown entire browser
    }
}
