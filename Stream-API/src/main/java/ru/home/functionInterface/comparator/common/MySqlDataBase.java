package ru.home.functionInterface.comparator.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDataBase {

    ConnectionConfig conConf = new ConnectionConfig("../../../../../mysql.properties");

//    private final String URL = "jdbc:mysql://localhost:3306/stream_api?createDatabaseIfNotExist=true";
//    private final String NAME = "root";
//    private final String PASSWORD = "hozku7-Jotqet-rexbat";

//    private final String URL = conConf.getUrl();
//    private final String NAME = conConf.getName();
//    private final String PASSWORD = conConf.getPassword();

    private Connection connection;

    private Statement statement;

    private final List<Cat> cats = new ArrayList<>();

    public List<Cat> getCatsFromDB() {
        return cats;
    }

    private void connect(ConnectionConfig config) throws SQLException {
        connection = DriverManager.getConnection(config.getUrl(), config.getName(), config.getPassword());
        statement = connection.createStatement();
    }

    public void run() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connect(conConf);
            dropTable("cats");
            createTable("cats");
            insert("cats", "Umka", 12);
            insert("cats", "Timka", 5);
            insert("cats", "Barsic", 8);
            insert("cats", "Luska", 5);
            insert("cats", "Kuzia", 2);
            getAll("cats");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private void createTable(String title) throws SQLException {
        statement.execute("create table if not exists " + title
                + "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "name TEXT, " +
                "age INTEGER)");
    }

    public void dropTable(String title) throws SQLException {
        statement.execute("drop table if exists " + title);
    }

    public void insert(String title, String name, int age) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("insert into " + title + " (name, age) values(?, ?)")) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        }
    }

    public void getAll(String title) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from " + title);
        while (rs.next()) {
            System.out.printf("id: %d | name: %s | age: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
            cats.add(new Cat(rs.getString(2), rs.getInt(3)));
        }
    }

    private void disconnect() {
        try {
            statement.execute("drop database if exists " + conConf.getUrl().substring(28, 38));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
