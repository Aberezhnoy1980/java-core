package ru.home.functionInterface.function.binaryFunction.apply;

import java.util.function.BiFunction;

public class ApplyApp {
    //R apply(T t, U u)
    // Создание объекта типа R, на основании объектов ссылки (T t, U u)
    // на которые используются в качестве параметра.
    public static void main(String[] args) {

        BiFunction<String, Character, Integer> countLetter = ApplyApp::count;

        System.out.println(countLetter.apply("Hello", 'l'));
    }

    public static Integer count(String letter, Character l) {
        int result = 0;
        char[] ls = letter.toCharArray();
        for (int i = 0; i < ls.length; i++) {
            if (ls[i] == l) {
                result++;
            }
        }
        return result;
    }
}
