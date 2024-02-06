package ru.home.functionInterface.binaryOperator.apply;

import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorInMethodParameterApp {

    public static void main(String... args) {

        List<Integer> integers = List.of(1, 2, 3);
        BinaryOperator<Integer> summator = (i1, i2) -> i1 + i2;
        Integer i = reduce(integers, summator, 0);
        System.out.println(i);

        List<String> strings = List.of("Hello", "Java", "World");
        BinaryOperator<String> concatenator = (s1, s2) -> s1 + "-> " + s2;
        String s = reduce(strings, concatenator, "");
        System.out.println(s);
    }

    public static <T> T reduce(List<T> list, BinaryOperator<T> binaryOperator, T startValue) {
        T result = startValue;
        for (T element : list) {
            result = binaryOperator.apply(element, result);
        }
        return result;
    }
}
