package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    private final By btnCancel = By.xpath("//table[@class='MyTable']//tr[last()]/td[last()]/input");
    private final By myTable = By.xpath("//div[@align='center']/div");
    private final By msg = By.xpath("//div[@class='message']/li");

}

