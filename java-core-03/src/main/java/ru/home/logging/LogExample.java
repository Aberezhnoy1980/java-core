package ru.home.logging;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogExample {
    private static final Logger LOGGER = LogManager.getLogger(LogExample.class);

    public static void main(String[] args) {
        System.out.println(LOGGER.getName());
        String str = "Hello world";

        LOGGER.trace("Trace");
        LOGGER.debug("Debug");
        LOGGER.info("Info");
        LOGGER.info("String: {}", str);
        LOGGER.warn("Warning");
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");
        exception();
    }

    private static void exception() {
        try {
            throw new RuntimeException("какая та шляпа внезапно приключилась блять");
        } catch (RuntimeException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
    }
}
