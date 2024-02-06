package ru.home.functionInterface.consumer.training;

import java.util.List;
import java.util.function.Consumer;

public class First {
    // Реализуйте Consumer<Integer> с помощью которого выведите на экран все нечетные числа содержащиеся в List<Integer>.
    public static void main(String... args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> evenIntCons = i -> {
            if (i % 2 != 0) System.out.println(i);
        };

        integers.forEach(evenIntCons);

    }
}
