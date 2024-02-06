package ru.home.functionInterface.optional.transformation;

import java.util.Optional;

public class OrApp {
    // Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
    // Если значение ссылки в Optional равно null то вернется новый Optional созданный на основе параметра.
    public static void main(String... args) {

        final String[] names = {null, null, "Vaska", null, "Barsik"};

        Optional<String> result = Optional.ofNullable(names[0]);

        for (String s : names) {
            Optional<String> temp = Optional.ofNullable(s);
            result = result.or(() -> temp);
        }

        System.out.println(result.orElseThrow());
    }
}
