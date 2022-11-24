package pageobject;

import common.BrowserManager;
import dataobject.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@title='Register']");
    private final By msgError = By.xpath("//p[@class='message error']");
    private final By msgSuccess = By.xpath("//div[@id='content']/p");
    private final By msgPIDError = By.xpath("//label[@for='pid' and @class='validation-error']");
    private final By msgPasswordError = By.xpath("//label[@for='password' and @class='validation-error']");

    private WebElement getTxtEmail() {

        return BrowserManager.DRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {

        return BrowserManager.DRIVER.findElement(txtPassword);
    }

    private  WebElement getTxtConfirmPassword() {

        return BrowserManager.DRIVER.findElement(txtConfirmPassword);
    }

    private  WebElement getTxtPID() {
        return BrowserManager.DRIVER.findElement(txtPID);
    }

    private  WebElement getBtnRegister() {

        return BrowserManager.DRIVER.findElement(btnRegister);
    }

    private  WebElement getMsgError() {

        return BrowserManager.DRIVER.findElement(msgError);
    }

    private  WebElement getMsgSuccess() {
        return BrowserManager.DRIVER.findElement(msgSuccess);
    }

    private  WebElement getMsgPIDError() {
        return BrowserManager.DRIVER.findElement(msgPIDError);
    }

    private  WebElement getMsgPasswordError() {
        return BrowserManager.DRIVER.findElement(msgPasswordError);
    }

    public void register(String email, String password, String confirmPassword, String PID) {
        Register register = new Register(email,password,confirmPassword,PID);
        goToTab("Register");
        scrollToFindElement(getBtnRegister());
        getTxtEmail().sendKeys(register.getEmail(email));
        getTxtPassword().sendKeys(register.getPassword(password));
        getTxtConfirmPassword().sendKeys(register.getConfirmPassword(confirmPassword));
        getTxtPID().sendKeys(register.getPID(PID));
        getBtnRegister().click();
    }

    public String getSuccessMsg() {
        return getMsgSuccess().getText();
    }

    public String getPIDErrorMsg() {
        return getMsgPIDError().getText();
    }

    public String getPasswordErrorMsg() {
        return getMsgPasswordError().getText();
    }

    public String getRegisterErrorMsg() {
        return getMsgError().getText();
    }
}
