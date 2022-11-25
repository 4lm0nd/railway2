package testcases;

import common.BrowserManager;
import common.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;
import utilities.Logger;
import utilities.Utilities;

public class TestCases0102 {

    private final String email = "TC01" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = "Password123";
    private final String confirmPassword = "Password123";
    private final String PID = "1234567890";
    private final GeneralPage generalPage = new GeneralPage();
    private final Logger logger = new Logger();
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();

    @BeforeMethod

    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);

    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.DRIVER.quit();
    }

    @Test
    public void TC01_Verify_User_can_filter_Manage_Ticket_table() {
        logger.info("Precondition: Create a new account");
        registerPage.register(email, password, confirmPassword, PID);
        logger.info("Step 1: Login");
        loginPage.login(email,password);
        logger.info("Step2: Go to Book Ticket page");
        generalPage.goToTab("Book ticket");
        logger.info("Step 3: Book 6 tickets");
        bookTicketPage.bookMultipleTickets(6);
        logger.info("Step 4: Go to My Ticket page");
        generalPage.goToTab("My ticket");
        logger.info("Step 5: Filter with depart station as Sai Gon");
        myTicketPage.filterByDepartStation("Sài Gòn");
        logger.info("Verify the table show proper ticket");
        generalPage.checkTextContain(myTicketPage.checkTicketInfo("Depart Station"), "Sài Gòn");
    }

    @Test
    public void TC02_Verify_error_displays_when_filter_an_unexist_ticket(){
        logger.info("Step 1: Login");
        loginPage.login(email,password);
        logger.info("Step2: Go to My ticket page");
        generalPage.goToTab("My ticket");
        logger.info("Step 3: Filter with status as paid");
        myTicketPage.filterByStatus("Paid");
        logger.info("Verify error display");
        String expectedMessage = "Sorry, can't find any results that match your filters. Please change the filters and try again.";
        generalPage.checkTextContain(myTicketPage.getErrorMessage(),expectedMessage);
    }
}
