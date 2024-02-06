package ru.home.functionInterface.predicate.training;

import java.util.function.IntPredicate;

public class Fifth {
    // Создайте такую реализацию IntPredicate которая будет возвращать true
    // в случае когда сумма цифр числа число четное. Например для 103 — вернет true, так 1+0+3 = 4.
    public static void main(String... args) {

        IntPredicate isEven = number -> number % 2 == 0;

        System.out.println(isEven.test(isSumOfDigitsEven(103)));
    }

    public static int isSumOfDigitsEven(Integer number) {
        char[] temp = Integer.toString(number).toCharArray();
        int sumOfNumbers = 0;
        for (char c : temp) {
            int n = Character.getNumericValue(c);
            sumOfNumbers += n;
        }
        return sumOfNumbers;
    }
}
