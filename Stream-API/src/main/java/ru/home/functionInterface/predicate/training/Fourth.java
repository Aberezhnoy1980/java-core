package ru.home.functionInterface.predicate.training;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;

public class Fourth {
    // Используя реализацию BiPredicate<Integer, String> реализуйте удаление из
    // Map<Integer, String> всех пар ключ-значение для которых длинна строки
    // значения не равна ключу этого значения. Например такая пара как {3: «Hello»}
    // должна быть удалена так как длинна «Hello» не равна 3, а пара вида {4: «Java»} останется.
    public static void main(String... args) {

        Map<Integer, String> words = new ConcurrentHashMap<>();
        words.put(1, "First");
        words.put(2, "Second");
        words.put(3, "Third");
        words.put(4, "Fourth");
        words.put(5, "Fifth");
        words.put(6, "sixth");
        words.put(7, "seventh");

        BiPredicate<Integer, String> pred = (i, s) -> i == s.length();

        for (Map.Entry<Integer, String> e : words.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
            if (pred.test(e.getKey(), e.getValue())) {
                System.out.println("number: " + e.getKey() + " = word length " + e.getValue());
                words.remove(e.getKey());
            }
        }
        System.out.println("new map: " + words);
    }
}
