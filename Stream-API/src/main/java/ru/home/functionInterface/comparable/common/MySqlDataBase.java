package ru.home.functionInterface.comparable.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDataBase {

    private Connection connection;

    private Statement statement;

    private final String url = "jdbc:mysql://localhost:3306/stream_api?createDatabaseIfNotExist=true";

    private final String user = "root";

    private final String password = "hozku7-Jotqet-rexbat";

    private final List<Cat> cats = new ArrayList<>();

    private void connect(String url, String user, String password) throws SQLException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(true);
        statement = connection.createStatement();
    }

    private void disconnect() {
        try {
            statement.execute("drop database " + url.substring(28, 38));
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

    public void run() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connect(url, user, password);
            dropTable("cats");
            createTable("cats");
            insert("cats", "Umka", 12);
            insert("cats", "Luska", 5);
            insert("cats", "Barsik", 8);
            insert("cats", "Timka", 4);
            insert("cats", "Kuzia", 2);
            getAll("cats");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public List<Cat> getCatsFromMySql() {
        return cats;
    }

    private void dropTable(String title) throws SQLException {
        statement.execute("drop table if exists " + title);
    }

    private void createTable(String title) throws SQLException {
        statement.executeUpdate("create table if not exists " + title
                + "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "name TEXT, " +
                "age INTEGER)");
    }

    private void insert(String title, String name, int age) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement("insert into " + title + "(name, age) values(?, ?)")) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        }
    }

    private void getAll(String title) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from " + title);
        while (rs.next()) {
            System.out.printf("id: %d | name: %s | age: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
            cats.add(new Cat(rs.getString(2), rs.getInt(3)));
        }

    }
}
