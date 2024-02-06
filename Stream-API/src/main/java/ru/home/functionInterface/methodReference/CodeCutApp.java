package ru.home.functionInterface.methodReference;

import java.util.Arrays;

public class CodeCutApp {

    public static void main(String... args) {

        String[] names = new String[]{"Anna", "Ira", "Alexander", "Katia"};

        Arrays.sort(names, CodeCutApp::compareStringLength);

        System.out.println(Arrays.toString(names));
    }

    private static int compareStringLength(String a, String b) {
        return a.length() - b.length();
    }
}

