package ru.home.functionInterface.unaryOperator.training;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class First {
    // С помощью реализации UnaryOperator замените все нечетные числа в списке целых чисел на нули.
    public static void main(String... args) {

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        UnaryOperator<Integer> intChange = First::changeEvenToZero;

        integers.replaceAll(intChange);

        System.out.println(integers);
    }

    private static Integer changeEvenToZero(Integer integer) {
        int result;
        if (integer % 2 == 0) result = 0;
        else result = integer;
        return result;
    }
}
