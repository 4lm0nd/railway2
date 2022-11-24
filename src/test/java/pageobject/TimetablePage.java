package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    private final String timeTable = "MyTable WideTable";
    private final String bookTicketBtn = "//table[@class='%s']//tr[%d]/td[last()]/a";

    private WebElement getBtnBookTicket(int row) {
        return BrowserManager.DRIVER.findElement(By.xpath(String.format(bookTicketBtn, timeTable, row)));
    }

    public int getTableRow(String table, String departStation, String arriveStation, int rows) {
        for (int i = 1; i <= rows; i++) {
            if (getTableCellValue(table, "Depart Station", i).equals(departStation))
                if (getTableCellValue(table, "Arrive Station", i).equals(arriveStation)) {
                    return i;
                }
        }
        return 0;
    }

    public void selectTrainFromTrainTimeTable(String departStation, String arriveStation) {
        int a = getTableRow(timeTable, departStation, arriveStation, 25);
        if (a != 0) {
            scrollToFindElement(getBtnBookTicket(a));
            getBtnBookTicket(a).click();
        } else {
            System.out.println("This train is not found");
        }
    }
}




