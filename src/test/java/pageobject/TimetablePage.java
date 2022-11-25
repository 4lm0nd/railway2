package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    private final String timeTable = "MyTable WideTable";
    private final String bookTicketBtn = "//table[@class='%s']//tr[%d]/td[last()]/a";
}




