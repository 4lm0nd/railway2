package testcases;

import common.BrowserManager;
import common.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;
import utilities.Logger;
import utilities.Utilities;

public class TestCaseManageTicket {
    private final String email = "alTC14" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = "Password123";
    private final String confirmPass = "Password123";
    private final String PID = "Password123";
    private final String departStation = "Quảng Ngãi";
    private final String arriveStation = "Nha Trang";
    private final String seatType = "Soft seat with air conditioner";
    private final String amount = "1";
    private final Utilities utilities = new Utilities();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
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
    public void TC14_TC16_Verify_User_can_book_and_cancel_for_A_ticket() {
        logger.info("Preconditions: Register a new account");
        registerPage.register(email, password, confirmPass, PID);
        logger.info("TC14_Verify_User can book 1 ticket at a time");
        logger.info("Step 1: Login");
        loginPage.login(email, password);
        logger.info("Step 2: Book a ticket");
        bookTicketPage.bookTicket(
                utilities.getDateLaterFromCurrentDate(7), departStation, arriveStation, seatType, amount);
        logger.info("Verify book ticket successfully");
        generalPage.checkTextContain(bookTicketPage.getSuccessMsg(),
                utilities.getExpectedMSg( "msg book ticket success"));
        generalPage.checkTextContain(bookTicketPage.getBookTicketInfo("Depart Station"), departStation);
        generalPage.checkTextContain(bookTicketPage.getBookTicketInfo("Arrive Station"), arriveStation);
        generalPage.checkTextContain(bookTicketPage.getBookTicketInfo("Seat Type"), seatType);
        generalPage.checkTextContain(bookTicketPage.getBookTicketInfo("Depart Date"),
                utilities.getDateLaterFromCurrentDate(7));
        generalPage.checkTextContain(bookTicketPage.getBookTicketInfo("Amount"), amount);
        logger.info("TC16_Verify_User can cancel a ticket");
        logger.info("Step 1: Go to My Ticket tab");
        generalPage.goToTab("My ticket");
        logger.info("Step 3: Cancel ticket");
        myTicketPage.cancelTicket();
        logger.info("Check the ticket disappears");
        String ticketInfo = departStation + " " + arriveStation + " " + seatType + " " + utilities.getDateLaterFromCurrentDate(7);
        String myTableInfo = myTicketPage.getMyTableTextContent();
        generalPage.checkTextDoesNotContain(myTableInfo, ticketInfo);
    }
}






