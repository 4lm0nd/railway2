package pageobject;

import org.openqa.selenium.By;

public class GeneralPage {
    private final String tabMenu = "//span[text()='%s']/ancestor::a";
    private final String cellTable = "//table[@class='%s']//tr[%d]/td[count(//tr[@class='TableSmallHeader']/th[contains(text(),'%s')]/preceding-sibling::th)+1]";
    private final By pageTitle = By.xpath("//div[@id='content']/h1");
}











