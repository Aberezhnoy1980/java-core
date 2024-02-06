package ru.sergeyarchipov.ideadebug;

public class StringReverse {
    public static void main(String... args) {

        stringReverse("Hello");
    }

    private static void stringReverse(String string) {
        final StringBuilder sb = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            sb.append(string.charAt(i));
        }
        System.out.println(sb);
    }
}
