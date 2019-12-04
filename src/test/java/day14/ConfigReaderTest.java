package day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    @Test
    public void test1() {
        String expectedBrowser = "chrome";
        //we write keys in "key" as a string
        //as return, you will get value
        //key=value
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);
        //read value of url property
        System.out.println("URL: " + ConfigurationReader.getProperty("url"));
        //read value of user_name property
        System.out.println("Username: " + ConfigurationReader.getProperty("user_name"));
        //read value of password property
        String password = ConfigurationReader.getProperty("password");
        System.out.println("Password: " + password);
    }
}
