package testcases;

import common.BrowserManager;
import common.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.GeneralPage;
import pageobject.LoginPage;
import utilities.Logger;
import utilities.Utilities;

public class TestCaseAdditionalPagesDisplayAfterLogin {
    private final String email = "almond.dh@yopmail.com";
    private final String password = "Password123";
    private final GeneralPage generalPage = new GeneralPage();
    private final LoginPage loginPage = new LoginPage();
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
    public void TC06_Verify_AdditionalPages_display_after_login() {
        logger.info("TC06_Verify_Additional pages display once user logged in");
        logger.info("Step 1: Login with valid account");
        loginPage.login(email, password);
        logger.info("Check My ticket tab is displayed");
        generalPage.checkElementExist(generalPage.getTabMenu("My ticket"));
        logger.info("Check user goes to My ticket page when clicking on My ticket tab");
        generalPage.goToTab("My ticket");
        Assert.assertEquals(generalPage.getTitlePage(), "Manage ticket");
        logger.info("check Change Password tab is displayed");
        generalPage.checkElementExist(generalPage.getTabMenu("Change password"));
        logger.info("Check user goes to Change Password page when clicking on Change password tab");
        generalPage.goToTab("Change password");
        Assert.assertEquals(generalPage.getTitlePage(), "Change password");
        logger.info("Check Log out tab is displayed");
        generalPage.checkElementExist(generalPage.getTabMenu("Log out"));
    }
}
