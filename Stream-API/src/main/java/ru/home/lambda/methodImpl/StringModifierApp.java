package ru.home.lambda.methodImpl;

public class StringModifierApp {

    public static void main(String... args) {

        StringModifier stringModifier1 = (text) -> text.toUpperCase() + " world"; // String::toUpperCase

        System.out.println(stringModifier1.getString("Hello"));

        StringModifier stringModifier2 = (text) -> {
            StringBuilder result = new StringBuilder();
            for (var let : text.toCharArray()) {
                if (Character.isLetter(let) || let == ' ') {
                    result.append(let);
                }
            }
            return result.toString();
        };

        System.out.println(stringModifier2.getString("hello123 world!?"));
    }
}
