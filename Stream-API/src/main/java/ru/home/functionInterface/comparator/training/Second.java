package ru.home.functionInterface.comparator.training;

import java.util.*;
import java.util.function.Function;

public class Second {
    // Используя составной Comparator реализуйте в List<Integer> поиск числа модуль которого наиболее близок к нулю.
    // Если встретятся два модуль которых одинаково близок к нулю(например 5 и -5) то верните положительное значение.
    public static void main(String... args) {

        List<Integer> integers = List.of(2, 5, -7, -5, 1, -1, 6);

//        Function<List<Integer>, List<Integer>> positiveInteger = ints -> {
//            List<Integer> positiveInts = new ArrayList<>();
//            for (Integer i : ints) {
//                if (i >= 0) positiveInts.add(i);
//            }
//            return positiveInts;
//        };
//
//        Function<List<Integer>, List<Integer>> negativeInteger = ints -> {
//            List<Integer> negativeInts = new ArrayList<>();
//            for (Integer i : ints) {
//                if (i < 0) negativeInts.add(i);
//            }
//            return negativeInts;
//        };
//
//        Integer minPositive = Collections.min(positiveInteger.apply(integers));
//        Integer maxNegative = Collections.max(negativeInteger.apply(integers));
//
//        System.out.println("minPositive is " + minPositive + " maxNegative is " + maxNegative);
//
//        Function<List<Integer>, List<Integer>> funForPositiveList = ints -> ints.stream().map(Math::abs).collect(Collectors.toList());
//
//        System.out.println(funForPositiveList.apply(integers));

        Function<List<Integer>, List<Integer>> positiveInts = Second::convertIntegerListToPositiveIntegerList;

        System.out.println(Collections.min(positiveInts.apply(integers), Integer::compare));

    }

    private static List<Integer> convertIntegerListToPositiveIntegerList(List<Integer> integers) {
        List<Integer> positiveInts = new ArrayList<>();
        for (Integer i : integers) {
            if (i < 0) positiveInts.add(Math.abs(i));
            else positiveInts.add(i);
        }
        return positiveInts;
    }
}
