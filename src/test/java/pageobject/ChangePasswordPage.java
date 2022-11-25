package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.BrowserManager;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@title='Change password']");
    private final By msgSuccess = By.xpath("//p[@class='message success']");
}

