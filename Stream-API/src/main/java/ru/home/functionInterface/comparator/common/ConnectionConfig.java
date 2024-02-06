package ru.home.functionInterface.comparator.common;

import java.io.IOException;
import java.util.Properties;

public class ConnectionConfig {

    private final String url;
    private final String name;

    private final String password;

    public ConnectionConfig(String fileName) {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        this.url = props.getProperty("url");
        this.name = props.getProperty("name");
        this.password = props.getProperty("password");
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
