package ru.home.functionInterface.optional.transformation;

import java.util.Optional;

public class FilterApp {
    // Optional<T> filter(Predicate<? super T> predicate)
    // Если реализация Predicate вернет true, то вернеться Optinal со значением, в противном случае Optional со значением null.
    public static void main(String... args) {

        final String[] names = {null, null, "Vaska", null, "Barsik"};

        Optional<String> result = Optional.ofNullable(names[0]);

        for (String s : names) {
            Optional<String> temp = Optional.ofNullable(s).filter(str -> str.startsWith("B"));
            result = result.or(() -> temp);
        }

        System.out.println(result.orElseThrow());
    }
}
