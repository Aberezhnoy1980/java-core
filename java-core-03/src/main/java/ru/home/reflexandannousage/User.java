package ru.home.reflexandannousage;

@AppTable(title = "users")
public class User {
    @AppField
    private int ID;

    @AppField
    private String username;

    @AppField
    private String password;

    @AppField
    private String email;

    @AppField
    private int age;
}
