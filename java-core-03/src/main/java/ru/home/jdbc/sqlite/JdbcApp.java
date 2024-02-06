package ru.home.jdbc.sqlite;

import java.sql.*;

public class JdbcApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect();
            dropAndCreateTable("students");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void preparedStatementExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i < 50; i++) {
            psInsert.setString(1, "BOB" + i);
            psInsert.setInt(2, 100 + i);
            psInsert.execute();
        }
        statement.executeBatch();
        connection.commit();
    }

    private static void prepareStatement() throws SQLException{
        psInsert = connection.prepareStatement("insert into students (name, score) values (?, ?);");
    }

    private static void batchExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i < 50; i++) {
            statement.addBatch(String.format("insert into students (name, score) values ('%s', 100);", "BOB #" + i));
        }
        statement.executeBatch();
        connection.commit();
    }

    private static void fillTable() throws SQLException {
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i < 50; i++) {
            statement.executeUpdate(String.format("insert into students (name, score) values ('%s', 100);", "BOB #" + i));
        }
        connection.setAutoCommit(true);
        System.out.println("TIME: " + (System.currentTimeMillis() - time));
    }

    private static void dropAndCreateTable(String title) throws SQLException {
        statement.execute("drop table if exists " + title);
        statement.executeUpdate("create table if not exists " + title + " (id integer primary key autoincrement, name text, score integer)");
    }

    // CRUD
    private static void readExample() throws SQLException {
        try (ResultSet rs = statement.executeQuery("select * from students where id > 1;")) {
            while (rs.next()) {
                System.out.println(rs.getLong(1) + " " +
                        rs.getString(2) + " " +
                        rs.getInt("score"));
            }
        }
    }

    private static void insertExample() throws SQLException {
        statement.executeUpdate("insert into students (name, score) values ('Max', 79);");
    }

    private static void deleteExample() throws SQLException {
        statement.executeUpdate("delete from students where name = 'max';");
    }

    private static void updateExample() throws SQLException {
        statement.executeUpdate("update students set name = 'Max' where id = 5;");
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite://Users/alex/Documents/Study/Practice/Java/java_core/java-core-03/src/main/java/ru/home/jdbc/sqlite/jdbc_practice");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Невозможно подключиться к БД");
        }
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
