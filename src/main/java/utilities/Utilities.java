package utilities;

import common.BrowserManager;
import common.Constant;
import common.ReadFileJson;
import dataobject.Message;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    public static String convertDateToString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constant.FULL_DATETIME);
        LocalDateTime localDate = LocalDateTime.now();
        String strDate = dateFormat.format(localDate);
        return strDate;
    }

    public static String getDateLaterFromCurrentDate(int days) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constant.SHORT_DATE_US);
        LocalDate localDate = LocalDate.now().plusDays(days);
        String fromDateFormat = dateFormat.format(localDate);
        return fromDateFormat;
    }

    public String getExpectedMSg(String jsNode) {
        Message message = new Message("MessageToVerify.json", jsNode);
        String msg = ReadFileJson.getJsonValue("MessageToVerify.json", jsNode);
        return msg;
    }
    public static void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserManager.DRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void waitForControl(By element, int timeoutInSeconds) {
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
    public static void scrollToFindElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserManager.DRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void acceptAlert() {
        Alert alert = BrowserManager.DRIVER.switchTo().alert();
        alert.accept();
    }

    public static void rejectAlert() {
        Alert alert = BrowserManager.DRIVER.switchTo().alert();
        alert.dismiss();
    }
    public static void selectItemByValue(By list, String option) {
        Select mySelect = new Select(BrowserManager.DRIVER.findElement(list));
        mySelect.selectByValue(option);
    }

    public static void selectItemByText(By list, String option) {
        Select mySelect = new Select(BrowserManager.DRIVER.findElement(list));
        mySelect.selectByVisibleText(option);
    }
    public static String getSelectedItem(WebElement selection) {
        Select selectedValue = new Select(selection);
        WebElement optionA = selectedValue.getFirstSelectedOption();
        return optionA.getText();
    }
}







