package testcases;

import common.BrowserManager;
import common.Constant;
import dataobject.Message;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.ChangePasswordPage;
import pageobject.GeneralPage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import utilities.Logger;
import utilities.Utilities;

public class TestCaseChangePassword {

    private final String email = "alTC09" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = "Password123";
    private final String password2 = "Password12345";
    private final String confirmPass = "Password123";
    private final String PID = "Password123";
    private final GeneralPage generalPage = new GeneralPage();
    private final Utilities utilities = new Utilities();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final Logger logger = new Logger();


    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
        logger.info("Preconditions: Register new account");
        registerPage.register(email, password, confirmPass, PID);
    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.DRIVER.quit();
    }

    @Test
    public void TC09_Verify_User_can_change_password() {
        logger.info("TC06_Verify_User can change password");
        logger.info("Step 1: Login");
        loginPage.login(email, password);
        logger.info("Step 2: Change password");
        changePasswordPage.changePassword(password, password2, password2);
        logger.info("Check success message appear");
        generalPage.checkTextContain(changePasswordPage.getSuccessMsg(),
                utilities.getExpectedMSg("msg change password success"));
    }
}
