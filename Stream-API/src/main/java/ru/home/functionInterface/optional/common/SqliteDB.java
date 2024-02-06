package ru.home.functionInterface.optional.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteDB {

    ConnConf connectionConfiguration = new ConnConf("../../../../../sqlite.properties");
    private Connection connection;
    private Statement statement;
    private final List<Cat> cats = new ArrayList<>();

    public List<Cat> getCatsFromSqlite() {
        return cats;
    }

    private void connect(ConnConf connectionConfiguration) throws SQLException {
        connection = DriverManager.getConnection(connectionConfiguration.getUrl());
        statement = connection.createStatement();
    }

    public void run() {
        try {
            connect(connectionConfiguration);
            dropTable("cats");
            createTable("cats");
            insert("cats", "Vaska", "Black");
            insert("cats", "Tishka", "Red");
            insert("cats", "Pidar", "White");
            getAll("cats");
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            disconnect();
        }
    }

    public void getAll(String title) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from " + title);
        while (rs.next()) {
            System.out.printf("id: %d | name: %s | color: %s%n", rs.getInt(1), rs.getString(2), rs.getString(3));
            cats.add(new Cat(rs.getString(2), rs.getString(3)));
        }
    }

    private void insert(String title, String name, String color) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("insert into " + title + " (name, color) values(?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, color);
            ps.executeUpdate();
        }
    }

    private void createTable(String title) throws SQLException {
        statement.executeUpdate("create table if not exists "
                + title
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, color TEXT)");
    }

    private void dropTable(String title) throws SQLException {
        statement.execute("drop table if exists " + title);
    }

    public void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }
}
