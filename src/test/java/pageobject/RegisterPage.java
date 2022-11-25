package pageobject;

import common.BrowserManager;
import dataobject.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

public class RegisterPage extends GeneralPage {

    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@title='Register']");

    private WebElement getTxtEmail() {
        return BrowserManager.DRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return BrowserManager.DRIVER.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return BrowserManager.DRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getTxtPID() {
        return BrowserManager.DRIVER.findElement(txtPID);
    }

    private WebElement getBtnRegister() {
        return BrowserManager.DRIVER.findElement(btnRegister);
    }

    public void register(String email, String password, String confirmPassword, String PID) {
        Register register = new Register(email, password, confirmPassword, PID);
        goToTab("Register");
        Utilities.scrollToFindElement(getBtnRegister());
        getTxtEmail().sendKeys(register.getEmail(email));
        getTxtPassword().sendKeys(register.getPassword(password));
        getTxtConfirmPassword().sendKeys(register.getConfirmPassword(confirmPassword));
        getTxtPID().sendKeys(register.getPID(PID));
        getBtnRegister().click();
    }
}


