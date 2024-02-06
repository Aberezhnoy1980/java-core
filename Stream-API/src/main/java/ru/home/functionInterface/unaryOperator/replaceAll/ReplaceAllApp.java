package ru.home.functionInterface.unaryOperator.replaceAll;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceAllApp {
    // default void replaceAll(UnaryOperator<E> operator)
    // Данный метод заменяет все элементы списка, применяя к каждому элементу списка реализацию UnaryOperator.
    public static void main(String... args) {

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4));

        UnaryOperator<Integer> doubleTheValue = i -> i * 2;

        integers.replaceAll(doubleTheValue);

        System.out.println(integers);

    }
}
