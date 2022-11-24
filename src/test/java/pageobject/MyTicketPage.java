package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    private String note = "You currently book 0 ticket, you can book 10 more.";

    //Locator
    private final By btnCancel = By.xpath("//table[@class='MyTable']//tr[last()]/td[last()]/input");
    private final By myTable = By.xpath("//div[@align='center']/div");

    private final By msg = By.xpath("//div[@class='message']/li");

    //Element
    private WebElement getBtnCancel() {
        return BrowserManager.DRIVER.findElement(btnCancel);
    }

    private WebElement getMyTable() {
        return BrowserManager.DRIVER.findElement(myTable);
    }

    private WebElement getMsg() {
        return BrowserManager.DRIVER.findElement(msg);
    }

    //Method
    public void cancelTicket() {
        getBtnCancel().click();
        acceptAlert();
    }

    public void cancelAllTickets() {
        while (!getNoteMsg().equals(note)) {
            scrollPageDown();
            cancelTicket();
            getNoteMsg().equals(getNoteMsg());
        }
    }

    public String getNoteMsg() {
        return getMsg().getText();
    }

    public String getMyTableTextContent() {
        return getMyTable().getText();
    }
}

