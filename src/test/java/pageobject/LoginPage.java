package pageobject;

import common.BrowserManager;
import dataobject.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@title='Login']");
    private final By msgError = By.xpath("//p[@class = 'message error LoginForm']");
}
