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
}
