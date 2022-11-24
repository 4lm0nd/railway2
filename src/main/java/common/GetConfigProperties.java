package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetConfigProperties {
    public static String getProperty(String key) {
        String configPropertiesPath = "Resources/config.properties";
        try (InputStream input = new FileInputStream(configPropertiesPath)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            String propertyValue = prop.getProperty(key);
            return propertyValue;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
