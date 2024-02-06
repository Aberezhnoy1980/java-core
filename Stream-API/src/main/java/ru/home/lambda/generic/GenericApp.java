package ru.home.lambda.generic;

public class GenericApp {

    public static void main(String... args) {

        Modifier<String> modifier = (text) -> text.toUpperCase();

        System.out.println(modifier.modification("hello"));
    }
}
