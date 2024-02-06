package ru.home.functionInterface.function.training;

import java.util.function.Function;
import java.util.function.IntPredicate;

public class First {
    // С помощью реализации Function<Integer[],Integer> и реализации
    // Predicate<Integer> (да нужно вспоминать и предыдущую лекцию ☺)
    // реализуйте функцию которая вернет количество простых чисел
    // в массиве целых чисел. Например [5,6,7,8,9,10] => 2
    public static void main(String... args) {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

//        int primesCount = getPrimesCount().apply(integers);

//        System.out.println(primesCount);

        System.out.println(getPrimesCount().apply(integers));
    }

    public static Function<Integer[], Integer> getPrimesCount() {
        return First::getCount;
    }

    public static Integer getCount(Integer[] integers) {
        int result = 0;
        for (Integer i : integers) {
            if (checkInteger().test(i)) {
                System.out.println(i);
                result++;
            }
        }
        return result;
    }

    public static IntPredicate checkInteger() {
        IntPredicate pr1 = i -> i > 1;
        IntPredicate pr2 = i -> Math.sqrt(i) > 1 && Math.sqrt(i) < 2;
        IntPredicate pr3 = i -> {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) return false;
            }
            return true;
        };
        return pr1.and(pr2.or(pr3));
    }
}
