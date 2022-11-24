package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Locators
    private final By lblWelcomeMessage = By.xpath("//div[@class ='account']/strong");

    //Elements
    private final WebElement getLblWelcomeMessage() {
        return BrowserManager.DRIVER.findElement(lblWelcomeMessage);
    }

    public String getWelcomeMsg() {
        return getLblWelcomeMessage().getText();
    }
}
