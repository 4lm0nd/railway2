package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;


public class MyTicketPage extends GeneralPage {

    private final By btnCancel = By.xpath("//table[@class='MyTable']//tr[last()]/td[last()]/input");
    private final By myTable = By.xpath("//div[@align='center']/div");
    private final By btnFilter = By.xpath("//input[@value='Apply Filter']");
    private final By listFilterDpStation = By.name("FilterDpStation");
    private final By listFilterStatus = By.name("FilterStatus");

    private WebElement getBtnFilter() {
        return BrowserManager.DRIVER.findElement(btnFilter);
    }
    private WebElement getListFilterStatus(){
        return BrowserManager.DRIVER.findElement(listFilterStatus);
    }

    private WebElement getListFilterDpStation() {
        return BrowserManager.DRIVER.findElement(listFilterDpStation);
    }
private WebElement getMyTable(){
        return BrowserManager.DRIVER.findElement(myTable);
}
    public void filterByDepartStation(String value) {
        Utilities.selectItemByText(listFilterDpStation,value);
        getBtnFilter().click();
    }

    public void filterByStatus (String value){
        Utilities.selectItemByText(listFilterStatus,value);
        getBtnFilter().click();
    }
    public String checkTicketInfo(String column) {
        String value = getTableCellValue("MyTable", column, 2);
        return value;
    }

    public String getErrorMessage(){
       String errorText =  getMyTable().getText();
        return errorText;
    }
}

