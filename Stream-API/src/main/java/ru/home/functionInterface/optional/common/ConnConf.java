package ru.home.functionInterface.optional.common;

import java.io.IOException;
import java.util.Properties;

public class ConnConf {
    private final String url;
    public ConnConf(String fileName) {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        this.url = props.getProperty("url");
    }

    public String getUrl() {
        return url;
    }
}
