package ru.home.functionInterface.binaryOperator.minMax;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class MinMaxApp {
    // static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
    // static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
    // Эти статические методы возвращают реализацию BinaryOperator которая возвращает минимальное и соответственно
    // максимальное значение из двух параметров. За сравнение отвечает реализация Comparator который используется в качестве параметра.
    public static void main(String... args) {

        Comparator<String> lengthCompare = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        BinaryOperator<String> findMaxString = BinaryOperator.maxBy(lengthCompare);

        System.out.println(findMaxString.apply("Java", "Python"));
    }
}
