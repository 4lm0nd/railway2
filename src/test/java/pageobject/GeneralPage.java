package pageobject;

import common.BrowserManager;
import common.Constant;
import common.ReadFileJson;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class GeneralPage {

    //Locator
    private final String tabMenu = "//span[text()='%s']/ancestor::a";
    private final String cellTable = "//table[@class='%s']//tr[%d]/td[count(//tr[@class='TableSmallHeader']/th[contains(text(),'%s')]/preceding-sibling::th)+1]";
    private final By pageTitle = By.xpath("//div[@id='content']/h1");

    //Element
    public WebElement getTabMenu(String tabName) {
        return BrowserManager.DRIVER.findElement(By.xpath(String.format(tabMenu, tabName)));
    }

    protected WebElement getPageTitle() {
        return BrowserManager.DRIVER.findElement(pageTitle);
    }

    protected WebElement getCellTable(String table, String column, int row) {
        return BrowserManager.DRIVER.findElement(By.xpath(String.format(cellTable, table, row, column)));
    }

    //Method
    public void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserManager.DRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void goToTab(String tab) {
        getTabMenu(tab).click();
    }

    public void selectItemFromList(By list, String option) {
        Select mySelect = new Select(BrowserManager.DRIVER.findElement(list));
        mySelect.selectByVisibleText(option);
    }

    public void waitForControl(By element, int timeoutInSeconds) {
        WebElement myElement = new WebDriverWait(BrowserManager.DRIVER, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
        boolean check = false;
        for (int i = 0; i < timeoutInSeconds; i++) {
            try {
                if (myElement.isDisplayed() != check) {
                    Thread.sleep(timeoutInSeconds * 1000);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getTitlePage() {
        return getPageTitle().getText();
    }

    public void openSite(String site) {
        BrowserManager.openBrowser(Constant.BROWSER, Constant.WEB_DRIVER, Constant.DRIVER_PATH);
        BrowserManager.DRIVER.get(site);
        BrowserManager.DRIVER.navigate();
    }

    public String getTableCellValue(String table, String column, int row) {
        return getCellTable(table, column, row).getText();
    }

    public void scrollToFindElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserManager.DRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String getSelectedItem(WebElement selection) {
        Select selectedValue = new Select(selection);
        WebElement optionA = selectedValue.getFirstSelectedOption();
        return optionA.getText();
    }

    public static void acceptAlert() {
        Alert alert = BrowserManager.DRIVER.switchTo().alert();
        alert.accept();
    }

    public static void rejectAlert() {
        Alert alert = BrowserManager.DRIVER.switchTo().alert();
        alert.dismiss();
    }

    public static void checkTextContain(String actualMsg, String expectedMsg) {
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(actualMsg, expectedMsg);
            softAssert.assertAll();

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static boolean doesElementDisplay(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static void checkElementExist(WebElement element) {
        try {
            Assert.assertTrue(doesElementDisplay(element));
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        } catch (AssertionError error) {
            System.out.println(error.getMessage());

        }
    }

    public static void checkSelectedItem(WebElement selection, String option) {
        Select selectedValue = new Select(selection);
        WebElement optionA = selectedValue.getFirstSelectedOption();
        String selectedOption = optionA.getText();
        try {
            Assert.assertEquals(selectedOption, option);
        } catch (AssertionError ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkElementDoesNotExist(WebElement element) {

        try {
            Assert.assertFalse(doesElementDisplay(element));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (AssertionError error) {
            System.out.println(error.getMessage());
        }
    }


    public static void checkTextDoesNotContain(String actualMsg, String expectedMsg) {
        try {
            Assert.assertFalse(actualMsg.contains(expectedMsg));

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String getExpectedMSg(String fileData, String jsNode) {
        String message = ReadFileJson.getJsonValue(fileData, jsNode);
        return message;
    }
}











