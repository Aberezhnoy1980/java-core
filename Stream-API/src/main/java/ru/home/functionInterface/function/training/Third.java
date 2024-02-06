package ru.home.functionInterface.function.training;

import java.util.function.Function;

public class Third {
    // Используя композицию функций реализуйте функцию которая вернет сумму кодов каждого символа в произвольной строке.
    public static void main(String... args) {

        String text = "Hello world!!!";

        Function<String, char[]> functionInParameter = a -> a.replaceAll(" ", "").toCharArray();

        Function<char[], Integer> currentFunction = Third::getSumOfCharCodes;

        System.out.println(currentFunction.compose(functionInParameter).apply(text));

    }

    private static Integer getSumOfCharCodes(char[] chars) {
        int sum = 0;
        for (Character ch : chars) {
            sum += (int) ch;
        }
        return sum;
    }
}
