package ru.home.functionInterface.function.util;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentApp {
    // default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
    // Этот метод пытается получить значение по указанному ключу (key). Если такой ключ есть
    // то метод вернет его значение. Если же такого ключа нет (или с ним связанно значение null)
    // то будет получено значение на основе ключа с использованием mappingFunction.
    // Эта пара будет добавлена в карту, вычисленное значение будет возвращено в результате работы метода.
    public static void main(String... args) {

        Map<Integer, String> numbers = new HashMap<>(Map.of(1, "one", 5, "five", 10, "ten"));

        Integer num = 2;

        String result = numbers.computeIfAbsent(num, n -> "number_" + n);

        System.out.println(numbers);

        System.out.println(result);
    }
}
