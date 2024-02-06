package ru.home.jdbc.sqlite.connection;

import java.io.IOException;
import java.util.Properties;

public class ConnectionConfig {
    private final String url;

    public ConnectionConfig(String filename) {
        Properties props = new Properties();

        try {
            props.load(getClass().getResourceAsStream(filename));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        this.url = props.getProperty("url");
    }

    public String getUrl() {
        return url;
    }
}
