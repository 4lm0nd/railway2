package common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetConfigProperties {

    public static void main(String[] args) {

        String configPropertiesPath = "Resources/config.properties";

        try (OutputStream output = new FileOutputStream(configPropertiesPath)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("RAILWAY_SITE","http:///www.railwayb1.somee.com");
            prop.setProperty("SHORT_DATE_US","M/d/yyyy");
            prop.setProperty("FULL_DATETIME","yyyyMMddhhmmss");
            prop.setProperty("WEB_DRIVER","webdriver.chrome.driver");
            prop.setProperty("DRIVER_PATH","Executables/chromedriver.exe");
            prop.setProperty("BROWSER","CHROME");

            // save properties to project root folder
            prop.store(output, null);
            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

