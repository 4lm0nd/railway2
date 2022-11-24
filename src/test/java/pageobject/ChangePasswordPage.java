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


    //Element
    private WebElement getTxtCurrentPassword() {
        return BrowserManager.DRIVER.findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return BrowserManager.DRIVER.findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return BrowserManager.DRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return BrowserManager.DRIVER.findElement(btnChangePassword);
    }

    private WebElement getMsgSuccess() {
        return BrowserManager.DRIVER.findElement(msgSuccess);
    }

    public void changePassword(String currentPass, String newPass, String confirmPass) {
        goToTab("Change password");
        scrollToFindElement(getBtnChangePassword());
        getTxtCurrentPassword().sendKeys(currentPass);
        getTxtNewPassword().sendKeys(newPass);
        getTxtConfirmPassword().sendKeys(confirmPass);
        getBtnChangePassword().click();
    }

    public String getSuccessMsg() {
        return getMsgSuccess().getText();
    }
}

