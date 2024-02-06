package ru.home.functionInterface.function.apply;

import java.util.function.Function;

public class ApplyWithMethodApp {

    public static void main(String[] args) {

        String text = "Java the best!";

        Function<String, Integer> fun = ApplyWithMethodApp::countWhiteSpace;

        System.out.println(applyToStr(text, fun));

    }

    public static Integer applyToStr(String text, Function<String, Integer> fun) {
        return fun.apply(text);
    }

    public static Integer countWhiteSpace(String text) {
        int count = 0;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') count += 1;
        }
        return count;
    }
}
