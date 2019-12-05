package vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import utils.TestBase;

public class CreateCalendarEventTests extends TestBase {


    @Test(description = "Verify owners name is equals to Pearl Wuckert (it works on qa1 storemenager85)")
    public void test1() {
        extentTest = extentReports.createTest("Verify owners name is equals to Pearl Wuckert");
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        //login as Stephan Haley (storemanager85)
        loginPage.login("storemanager85", "UserUser123");

        //go to calendar events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click on create calendar event button
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = "Pearl Wuckert";
        String actualOwner = createCalendarEventPage.owner.getText().trim();

        Assert.assertEquals(actualOwner, expectedOwner);

        extentTest.pass("Verified owners name is Pearl Wuckert");

    }
}