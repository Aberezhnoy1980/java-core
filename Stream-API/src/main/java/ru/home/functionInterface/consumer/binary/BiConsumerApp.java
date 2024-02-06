package ru.home.functionInterface.consumer.binary;

import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerApp {
    // void accept(T t, U u)
    // Операция над объектами ссылки на которые используются в качестве параметров. Не возвращает результат.
    public static void main(String... args) {

        BiConsumer<String, Integer> biCons = (a, b) -> System.out.println((a + "\n").repeat(b));

        biCons.accept("Hello", 5);

        // bi in forEach

        Map<Integer, String> simpleMap = Map.of(1, "One", 2, "Two", 5, "Five");

        BiConsumer<Integer, String> biConsFoMap = (a, b) -> System.out.print((b + "\n").repeat(a));

        simpleMap.forEach(biConsFoMap);
    }
}
