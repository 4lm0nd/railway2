package pageobject;

import common.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GeneralPage {
    private final String tabMenu = "//span[text()='%s']/ancestor::a";
    private final String cellTable = "//table[@class='%s']//tr[%d]/td[count(//tr[@class='TableSmallHeader']/th[contains(text(),'%s')]/preceding-sibling::th)+1]";
    private final By pageTitle = By.xpath("//div[@id='content']/h1");

    protected WebElement getTabMenu(String tabName) {
        return BrowserManager.DRIVER.findElement(By.xpath(String.format(tabMenu, tabName)));
    }

    protected WebElement getCellTable(String table, String column, int row) {
        return BrowserManager.DRIVER.findElement(By.xpath(String.format(cellTable, table, row, column)));
    }

    public void openSite(String site) {
        BrowserManager.openBrowser();
        BrowserManager.DRIVER.get(site);
        BrowserManager.DRIVER.navigate();
    }

    public void goToTab(String tab) {
        getTabMenu(tab).click();
    }

    public String getTableCellValue(String table, String column, int row) {
        return getCellTable(table, column, row).getText();
    }

    public static void checkTextContain(String actualMsg, String expectedMsg) {
        try {
            Assert.assertEquals(actualMsg,expectedMsg);

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }
}











