package ru.home.functionInterface.function.training;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Second {
    // Опишите такую реализацию Function<String, Integer> которая вернет количество согласных букв в строке текста.
    public static void main(String[] args) {

        // with predicate
        String text = "This task is easier than the previous one!?!<_+=-345";

        System.out.println(getConsonantsCount().apply(text) + " consonants in [" + text + "]");

        // with BiFunction
        String regex = "[\\W_0-9]";

        BiFunction<String, String, char[]> fun1 = (a, b) -> a.replaceAll(b, "").toLowerCase().toCharArray();

        Function<char[], Integer> fun2 = chars -> {
            int result = 0;
            for (Character ch : chars) {
                if (ch.toString().matches("[^aeiouy]")) {
                    result++;
                }
            }
            return result;
        };

        Function<char[], Integer> fun4 = chars -> text
                .replaceAll("[aeiouy\\W_0-9]", "")
                .toLowerCase()
                .toCharArray()
                .length;

        BiFunction<String, String, Integer> fun3 = fun1.andThen(fun2);
        BiFunction<String, String, Integer> fun5 = fun1.andThen(fun4);

        System.out.println(fun3.apply(text, regex));
        System.out.println(fun5.apply(text, regex));
    }

    private static Function<String, Integer> getConsonantsCount() {
        return Second::getConsonantsCountMethodImpl;
    }

    public static Integer getConsonantsCountMethodImpl(String text) {
        Integer count = 0;
        for (Character ch : text.replaceAll("[\\W_0-9]", "").toLowerCase().toCharArray()) {
            if (isConsonant().test(ch)) {
                count++;
            }
        }
        return count;
    }

    private static Predicate<Character> isConsonant() {
        return c -> c.toString().toLowerCase().matches("[^aeiouy]");
    }
}
