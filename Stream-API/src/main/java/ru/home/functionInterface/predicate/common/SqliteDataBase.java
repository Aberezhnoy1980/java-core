package ru.home.functionInterface.predicate.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteDataBase {

    private Connection connection;

    private Statement statement;

    public List<Cat> getCatsFromDB() {
        return cats;
    }

    private final List<Cat> cats = new ArrayList<>();

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite://Users/alex/Documents/Study/Practice/Java/java_core/Stream-API/src/main/java/ru/home/functionInterface/predicate/common/cats.db");
        connection.setAutoCommit(true);
        statement = connection.createStatement();
    }

    private void disconnect() {
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
            connect();
            dropTable("cats");
            createTable("cats");
            insert("cats", "Umka", 12);
            insert("cats", "Luska", 5);
            insert("cats", "Barsik", 8);
            insert("cats", "Timka", 4);
            insert("cats", "Kuzia", 2);
            getAll("cats");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private void dropTable(String title) throws SQLException {
        statement.execute("drop table if exists " + title);
    }
    private void createTable(String title) throws SQLException {
        statement.executeUpdate("create table if not exists "
                + title
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)");
    }

    private void insert(String title, String name, Integer age) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement("insert into " + title + " (name, age) values (?, ?)")) {
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
}
