package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutor {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");

    }

    @Test(description = "scroll down")
    public void test1() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            // move 700 px down
            js.executeScript("window.scrollBy(0,700);");
            BrowserUtils.wait(1);
        }
        driver.get("https://www.amazon.com/");
        BrowserUtils.wait(2);
        js.executeScript("window.scrollBy(0,700);");
        BrowserUtils.wait(2);

    }

    @Test(description = "scrolling by specific element")
    public void test2() {
        driver.get("http://practice.cybertekschool.com/large");
        driver.manage().window().maximize();


        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);


//        js code from the browser
//        var footer = document.getElementById('page-footer');
//        footer.scrollIntoView(true);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // script scroll until link element is visible
        // once link element will be visible stop scrolling
        //arguments[0] = means first webelement after comma (link)
        //arguments it's an array of webelements after comma
        //arguments[0] = link web element, it can be any web element
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(2);

    }

    //    var btn1 = document.getElementsByTagName('a')[1];
    //    btn1.click()
    @Test(description = "Click with JS executor")
    public void test3() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // arguments[0] = link1 web element
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);
    }

    @Test(description = "Enter text with JS executor")
    public void test4() {
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submit = driver.findElement(By.name("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'johnsmith@email.com')", email);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()",submit);
        BrowserUtils.wait(3);
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
