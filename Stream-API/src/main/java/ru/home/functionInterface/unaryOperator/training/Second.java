package ru.home.functionInterface.unaryOperator.training;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Second {
    // Создайте реализацию UnaryOperator<String> где результатом будет строка в которой исключены все символы
    // кроме цифровых. Т.е. если входящим параметром является строка вида «Hello 123 world» результатом будет строка «123».
    public static void main(String... args) {

        String expression = "Hello 123 world";

        UnaryOperator<String> stringFormat = Second::getString;

        System.out.println(stringFormat.apply(expression));
    }

    private static String getString(String s) {
        StringBuilder result = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (ch.toString().matches("[0-9]")) {
                result.append(ch);
            }
        }
        return String.valueOf(result);
    }
}
