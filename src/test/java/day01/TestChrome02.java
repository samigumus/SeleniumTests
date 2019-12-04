package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class TestChrome02 {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().driverRepositoryUrl(new URL("https://chromedriver.storage.googleapis.com/")).setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
    }
}
