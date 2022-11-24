package utilities;

import common.Constant;
import common.ReadFileJson;
import dataobject.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    //Method
    public static String convertDateToString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constant.FULL_DATETIME);
        LocalDateTime localDate = LocalDateTime.now();
        String strDate = dateFormat.format(localDate);
        return strDate;
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
}







