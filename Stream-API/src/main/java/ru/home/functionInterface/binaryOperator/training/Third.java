package ru.home.functionInterface.binaryOperator.training;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Third {
    // Создайте реализацию BinaryOperator<List<T extends Comparable<T>> который будет возвращать список
    // в котором находиться минимальный элемент среди двух списков использованных в качестве параметра.
    // Например для списков [5,0,3,4] и [10,-2, 5] нужно вернуть [10, -2, 5] так как элемент -2 минимален среди элементов этих списков.
    public static void main(String... args) {

        List<Integer> list1 = List.of(2, -3, 5, 8, 12);
        List<Integer> list2 = List.of(2, 5, -7, 12, 6);

//        Comparator<List<Integer>> compareLists = (l1, l2) -> Integer.compare(Collections.min(l1), Collections.min(l2));
//        Comparator<List<Integer>> compareLists = Comparator.comparingInt(Collections::min);
        Comparator<List<Integer>> compareLists = Third::compareLists;

        BinaryOperator<List<Integer>> findListContainsMinValue = BinaryOperator.minBy(compareLists);

        System.out.println(findListContainsMinValue.apply(list1, list2));
    }

    private static int compareLists(List<Integer> integers, List<Integer> integers1) {
        int minFromList1 = Collections.min(integers);
        int minFromList2 = Collections.min(integers1);
        return Integer.compare(minFromList1, minFromList2);
    }
}
