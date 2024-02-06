package ru.home.functionInterface.binaryOperator.training;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Second {
    // Создайте реализацию BinaryOperator<List<Integer>> которая вернет список в котором будут только те элементы
    // которые одновременно присутствуют в первом и во втором списке целых чисел использованных в качестве параметров.
    public static void main(String... args) {

        List<Integer> list1 = List.of(2, 5, 7, 3, 21, 43, 14);
        List<Integer> list2 = List.of(3, 15, 76, 14, 7, 21, 34);

        BinaryOperator<List<Integer>> binaryOperator = Second::findRepeatElement;
        BinaryOperator<List<Integer>> binaryOperator1 = Second::findRepeatElementExt;

        System.out.println(binaryOperator.apply(list1, list2));
        System.out.println(binaryOperator1.apply(list1, list2));

    }

    private static List<Integer> findRepeatElement(List<Integer> integers, List<Integer> integers1) {
        List<Integer> repeatingInts = new ArrayList<>();
        for (Integer integer : integers) {
            for (Integer value : integers1) {
                if (integer.equals(value)) {
                    repeatingInts.add(value);
                }
            }
        }
        return repeatingInts;
    }

    private static List<Integer> findRepeatElementExt(List<Integer> integers, List<Integer> integers1) {
        List<Integer> repeatingInts = new ArrayList<>();
        for (Integer value : integers) {
            if (integers1.contains(value)) {
                repeatingInts.add(value);
            }
        }
        return repeatingInts;
    }
}
