package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BrowserManager;
import common.Constant;
import pageobject.GeneralPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.Logger;
import utilities.Utilities;

public class TestCaseLogin {

    private final String email = "almond.dh@yopmail.com";
    private final String password = "Password123";
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final Utilities utilities = new Utilities();
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
    public void TC01_Verify_User_can_login_with_valid_data() {
        logger.info("TC01_Verify_User can log into Railway with valid username and password");
        logger.info("Step 1: Login with valid account");
        loginPage.login(email, password);
        String expectedMsg = "Welcome " + email;
        logger.info("Check success message");
        generalPage.checkTextContain(homePage.getWelcomeMsg(), expectedMsg);
    }

    @Test
    public void TC02_Verify_User_cannot_login_without_username() {
        logger.info("TC02_Verify_User cannot login with blank username");
        logger.info("Step 1: Login with blank user");
        loginPage.login("", password);
        logger.info("Check error message appear");
        generalPage.checkTextContain(loginPage.getLoginErrorMsg(),
                utilities.getExpectedMSg( "msg login error"));
    }

    @Test
    public void TC03_Verify_User_cannot_login_with_invalid_password() {
        logger.info("TC03_Verify_User cannot log into Railway with invalid password ");
        logger.info("Step 1: Login with invalid password");
        loginPage.login(email, "INVALID_PASSWORD");
        logger.info("Check error message appear");
        generalPage.checkTextContain(loginPage.getLoginErrorMsg(),
                utilities.getExpectedMSg( "msg validation"));
    }

    @Test
    public void TC04_Verify_User_cannot_goto_BookTicket_without_login() {
        logger.info("TC04_Verify_Login page displays when un-logged User clicks on Book ticket tab");
        logger.info("Step 1: Go to the book ticket page without login");
        generalPage.goToTab("Book ticket");
        logger.info("Check Login page is displayed");
        generalPage.checkTextContain(generalPage.getTitlePage(), "Login page");
    }

    @Test
    public void TC05_Verify_Error_message_display_when_logging_in_fails_multiple_times() {
        logger.info("TC05_Verify_System shows message when user enters wrong password several times");
        logger.info("Step 1: Login multiple(6) times");
        loginPage.multipleLogin("INVALID_EMAIL", "INVALID_PASSWORD", 6);
        logger.info("Check error message appear");
        generalPage.checkTextContain(loginPage.getLoginErrorMsg(),
                utilities.getExpectedMSg( "msg login fail multiple times"));
    }
}

