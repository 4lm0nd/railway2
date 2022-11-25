package pageobject;

import common.BrowserManager;
import common.Constant;
import dataobject.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;


public class BookTicketPage extends GeneralPage {
    private final By listDepartDate = By.xpath("//select[@name = 'Date']");
    private final By btnBookTicket = By.xpath("//input[@value ='Book ticket']");
    private final By listDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By listArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private final By listSeatType = By.xpath("//select[@name ='SeatType']");
    private final By listTicketAmount = By.xpath("//select[@name ='TicketAmount']");

    private WebElement getListDepartDate() {
        return BrowserManager.DRIVER.findElement(listDepartDate);
    }

    private WebElement getBtnBookTicket() {
        return BrowserManager.DRIVER.findElement(btnBookTicket);
    }

    private WebElement getListDepartFrom() {
        return BrowserManager.DRIVER.findElement(listDepartFrom);
    }

    private WebElement getListArriveAt() {
        return BrowserManager.DRIVER.findElement(listArriveAt);
    }

    private WebElement getListSeatType() {
        return BrowserManager.DRIVER.findElement(listSeatType);
    }

    private WebElement getTicketAmount() {
        return BrowserManager.DRIVER.findElement(listTicketAmount);
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType) {
        BookTicket bookTicket = new BookTicket(departDate, departStation, arriveStation, seatType);
        goToTab("Book ticket");
        Utilities.scrollToFindElement(getBtnBookTicket());
        Utilities.selectItemByText(listDepartDate,departDate);
        Utilities.selectItemByText(listDepartFrom,departStation);
        Utilities.waitForControl(listArriveAt, Constant.WAIT_CONTROL_TIME);
        Utilities.selectItemByText(listArriveAt,arriveStation);
        Utilities.selectItemByText(listSeatType,seatType);
        Utilities.waitForControl(btnBookTicket, Constant.WAIT_CONTROL_TIME);
        getBtnBookTicket().click();
    }

    public void bookMultipleTickets(int amount) {
        String[] departStation = {"Sài Gòn", "Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi"};
        String departDate = Utilities.getSelectedItem(getListDepartDate());
        String[] arriveAt = {"Quảng Ngãi", "Nha Trang", "Huế" , "Nha Trang","Nha Trang" , "Nha Trang", };
        String seatType = "Soft seat with air conditioner";
        String ticketAmount ="2";
        for (int i = 0; i < amount; i++) {
            bookTicket(departDate, departStation[i], arriveAt[i], seatType);
        }
    }
}









