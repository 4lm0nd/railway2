package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Logger {

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(Logger.class);

    static {
        String log4jConfPath = "resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    public void info(String message) {
        logger.info(String.format(message));
    }

}

