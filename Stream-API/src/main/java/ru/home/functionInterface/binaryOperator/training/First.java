package ru.home.functionInterface.binaryOperator.training;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class First {
    // Создайте реализацию BinaryOperator<String> которая будет возвращать самое длинное слово из двух
    // строк переданных в качестве параметров.
    public static void main(String... args) {

        Comparator<String> stringCompare = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        BinaryOperator<String> findMaxStringName = BinaryOperator.maxBy(stringCompare);

        System.out.println(findMaxStringName.apply("Java", "PHP"));
    }
}
