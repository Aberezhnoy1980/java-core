package ru.home.functionInterface.comparator.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class Fourth {
    // Создайте такую реализацию Comparator<Integer> что бы с ее помощью можно было найти максимальное
    // простое число в списке целых чисел, если такого числа в списке нет то должно быть возвращено минимальное число.
    public static void main(String... args) {

        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> ints2 = new ArrayList<>(List.of(1, 4, 6, 8, 9, 10));

        Function<List<Integer>, List<Integer>> primesList = Fourth::getPrimesList;

        List<Integer> primes = primesList.apply(ints2);

        int res = getResult(ints2, primes);

        System.out.println(res);

    }

    private static int getResult(List<Integer> ints, List<Integer> primes) {
        if(!primes.isEmpty())
            return Collections.max(primes);
        return Collections.min(ints);
    }

    private static List<Integer> getPrimesList(List<Integer> integers) {
        List<Integer> primesList = new ArrayList<>();
        for (Integer i : integers) {
            if (checkInteger().test(i)) primesList.add(i);
        }
        return primesList;
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
