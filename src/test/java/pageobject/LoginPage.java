package pageobject;

import common.BrowserManager;
import dataobject.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

public class LoginPage extends GeneralPage {
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@title='Login']");

    private WebElement getTxtEmail() {
        return BrowserManager.DRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return BrowserManager.DRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return BrowserManager.DRIVER.findElement(btnLogin);}

    public void login (String email, String password) {
        Login login = new Login(email,password);
        goToTab("Login");
        Utilities.scrollToFindElement(getBtnLogin());
        getTxtEmail().click();
        getTxtEmail().sendKeys(login.getEmail(email));
        getTxtPassword().click();
        getTxtPassword().sendKeys(login.getPass(password));
        getBtnLogin().click();
    }
}

