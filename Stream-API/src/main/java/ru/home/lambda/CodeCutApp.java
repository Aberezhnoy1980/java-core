package ru.home.lambda;

import java.util.Arrays;

public class CodeCutApp {

    public static void main(String... args) {

        String[] names = new String[]{"Anna", "Ira", "Alexander", "Katia"};

        Arrays.sort(names, (a, b) -> a.length() - b.length()); // Comparator.comparingInt(String::length)

        System.out.println(Arrays.toString(names));
    }
}
