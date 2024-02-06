package ru.home.functionInterface.comparator.naturalOrder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NaturalOrderApp {
    // static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
    // static <T extends Comparable<? super T>> Comparator<T> reverseOrder()
    // Эти методы используются для создания Comparator на основании реализации интерфейса
    // Comparable для указанных типов данных. Метод naturalOrder создает Comparator,
    // а метод reverseOrder создает «обратный» Comparator.
    public static void main(String... args) {

        List<Integer> integersList = List.of(5, 7, -2, 3, 8);

        Comparator<Integer> naturalOrder = Comparator.<Integer>naturalOrder();

        Comparator<Integer> reverseOrder = Comparator.<Integer>reverseOrder();

        Integer min = Collections.min(integersList, naturalOrder);

        Integer max = Collections.min(integersList, reverseOrder);

        System.out.println("min through naturalOrder is " + min + " min through reverseOrder is " + max);
    }
}
