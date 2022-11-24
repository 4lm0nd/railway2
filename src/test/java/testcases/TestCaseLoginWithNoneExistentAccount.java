package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BrowserManager;
import common.Constant;
import pageobject.GeneralPage;
import pageobject.LoginPage;
import utilities.Logger;
import utilities.Utilities;

public class TestCaseLoginWithNoneExistentAccount {
    private final String email = "alTC08" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = "Password123";
    private final GeneralPage generalPage = new GeneralPage();
    private final Utilities utilities = new Utilities();
    private final LoginPage loginPage = new LoginPage();
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
    public void TC08_Login_with_nonexistent_account() {
        logger.info("TC08_Verify_User can't login with an account hasn't been registered");
        logger.info("Step 1: Login with an account that hasn't been registered");
        loginPage.login(email, password);
        logger.info("Check unsuccessfully login");
        generalPage.checkTextContain(loginPage.getLoginErrorMsg(),
                utilities.getExpectedMSg( "msg validation"));
    }
}
