package pageobject;

import common.BrowserManager;
import common.Constant;
import dataobject.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class BookTicketPage extends GeneralPage {
    private final By listDepartDate = By.xpath("//select[@name = 'Date']");
    private final By btnBookTicket = By.xpath("//input[@value ='Book ticket']");
    private final By listDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By listArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private final By listSeatType = By.xpath("//select[@name ='SeatType']");
    private final By listTicketAmount = By.xpath("//select[@name ='TicketAmount']");
    private final By msgSuccess = By.xpath("//div[@id='content']/h1");
}








