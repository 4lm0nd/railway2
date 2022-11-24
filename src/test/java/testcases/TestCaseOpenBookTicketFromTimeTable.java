package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BrowserManager;
import common.Constant;
import pageobject.BookTicketPage;
import pageobject.GeneralPage;
import pageobject.LoginPage;
import pageobject.TimetablePage;
import utilities.Logger;
import utilities.Utilities;

public class TestCaseOpenBookTicketFromTimeTable {

    private final String email = "almond.dh@yopmail.com";
    private final String password = "Password123";
    private final Utilities utilities = new Utilities();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final TimetablePage timetablePage = new TimetablePage();
    private final GeneralPage generalPage = new GeneralPage();
    private final Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.DRIVER.quit();
   }

    @Test
    public void TC15_Verify_User_can_open_BookTicketPage_from_TrainTimeTable() {
        logger.info("TC15_Verify_User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        logger.info("Step 1: Login");
        loginPage.login(email, password);
        logger.info("Step 2: Go to Timetable page");
        generalPage.goToTab("Timetable");
        logger.info("Step 3: Click on book ticket button routed from Hue to Nha Trang");
        generalPage.scrollPageDown();
        timetablePage.selectTrainFromTrainTimeTable("Huế", "Nha Trang");
        logger.info("Check book ticket page is loaded with correct Depart From and Arrive At");
        generalPage.checkTextContain(bookTicketPage.getDepartStation(),"Huế");
        generalPage.checkTextContain(bookTicketPage.getArriveStation(),"Nha Trang");
    }
}


