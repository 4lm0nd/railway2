package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BrowserManager;
import common.Constant;
import pageobject.GeneralPage;
import pageobject.RegisterPage;
import utilities.Logger;
import utilities.Utilities;
public class TestCaseCreateNewAccount {

    private final String emailTC07 = "al07" + Utilities.convertDateToString() + "@yopmail.com";
    private final String emailTC10 = "al10" + Utilities.convertDateToString() + "@yopmail.com";
    private final String emailTC11 = "al11" + Utilities.convertDateToString() + "@yopmail.com";

    private final String password = "Password123";
    private final String password2 = "Password1234";
    private final String confirmPass = "Password123";
    private final String PID = "Password123";
     private final GeneralPage generalPage = new GeneralPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final Utilities utilities = new Utilities();
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
    public void TC07_Verify_User_can_create_account_with_valid_data() {
        logger.info("TC07_Verify_User can create new account");
        logger.info("Step 1: Create new account with valid data");
        registerPage.register(emailTC07, password, confirmPass, PID);
        logger.info("Check success message appear");
        generalPage.checkTextContain(registerPage.getSuccessMsg(),
                utilities.getExpectedMSg( "mgs register success"));
    }

    @Test
    public void TC10_Verify_User_cannot_create_account_with_mismatched_passwords() {
        logger.info("TC10_Verify_User can't create account with Confirm password is not the same with Password");
        logger.info("Step 1: Create new account with confirm password is not the same with password");
        registerPage.register(emailTC10, password, password2, PID);
        logger.info("Check error message appear");
        generalPage.checkTextContain(registerPage.getRegisterErrorMsg(),
                utilities.getExpectedMSg( "msg register error"));
    }

    @Test
    public void TC11_Verify_User_cannot_create_account_without_PID() {
        logger.info("TC11_Verify_User can't create account while password and PID fields are empty");
        logger.info("Step 1: Create new account with blank password and pid");
        registerPage.register(emailTC11, "", "", "");
        logger.info("Check error message appear");
       generalPage.checkTextContain(registerPage.getRegisterErrorMsg(),
                utilities.getExpectedMSg( "msg register error"));
       generalPage.checkTextContain(registerPage.getPasswordErrorMsg(),
                utilities.getExpectedMSg( "msg password validation"));
        generalPage.checkTextContain(registerPage.getPIDErrorMsg(),
                utilities.getExpectedMSg( "msg pid validation"));
    }
}
