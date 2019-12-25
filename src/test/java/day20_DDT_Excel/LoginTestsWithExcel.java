package day20_DDT_Excel;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver;
import utils.ExcelUtil;
import utils.TestBase;

public class LoginTestsWithExcel extends TestBase {

    @Test(dataProvider = "credentials", description = "Login with different credentials")
    public void loginTest(String username, String password, String firstName, String lastName, String result) {

        extentTest = extentReports.createTest("Login as: "+username);

        LoginPage loginpage = new LoginPage();
        loginpage.login(username, password);
        Assert.assertEquals(Driver.get().getTitle(), "Dashboard");

        extentTest.pass("Login test passed for user: "+username+" name: "+ firstName);
    }

    //is a test data supplier
    //as many sets of data it returns
    //as many times exactly same test will run
    @DataProvider(name = "credentials")
    public static Object[][] credentials() {
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();

    }


    /* public static void main(String[] args) {
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        System.out.println("Row count: "+ qa2.rowCount());
        System.out.println(qa2.getColumnsNames());
        for(Map<String, String> map: qa2.getDataList() ){
            System.out.println(map.get("username"));
        }
    } */

}
