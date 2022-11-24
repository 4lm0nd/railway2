package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static WebDriver DRIVER;

    public static void openBrowser(String browserName, String webDriver, String driverPath) {
        driverManager(browserName, webDriver, driverPath);
        maximizeWindow();
        deleteAllCookies();
        setImplicitlyWait(Constant.WAIT_SHORT_TIME);
        setPageLoadTimeout(Constant.WAIT_SHORT_TIME);
    }

    public static WebDriver driverManager(String browserName, String webDriver, String driverPath) {
        System.setProperty(webDriver, driverPath);
        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                DRIVER = new FirefoxDriver();
                break;
            case "CHROME":
                DRIVER = new ChromeDriver();
                break;
            case "IE":
                DRIVER = new InternetExplorerDriver();
                break;
            case "SAFARI":
                DRIVER = new SafariDriver();
                break;
        }
        return DRIVER;
    }

    public static void maximizeWindow() {
        BrowserManager.DRIVER.manage().window().maximize();
    }

    public static void deleteAllCookies() {
        BrowserManager.DRIVER.manage().deleteAllCookies();
    }

    public static void setImplicitlyWait(int timeToWait) {
        BrowserManager.DRIVER.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public static void setPageLoadTimeout(int timeToWait) {
        BrowserManager.DRIVER.manage().timeouts().pageLoadTimeout(timeToWait, TimeUnit.SECONDS);
    }
}



