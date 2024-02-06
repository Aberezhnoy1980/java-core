package ru.home.functionInterface.optional.transformation;

import java.util.Optional;

public class FlatMapApp {
    // Optional<U> flatMap(Function<? super T,? extends Optional<? extends U>> mapper)
    // Если значение ссылки в Optional не равно null то создается новый Optional на основание текущего Optional.
    // В противном случае вернется пустой Optional.
    public static void main(String... args) {

        final String[] names = {null, null, "Vaska", null, "Barsik"};

        Optional<String> result = Optional.ofNullable(names[0]);

        for (String s : names) {
            Optional<String> temp = Optional.ofNullable(s).flatMap(str -> Optional.of(str.toUpperCase()));
            result = result.or(() -> temp);
        }

        System.out.println(result.orElse("Torch"));
    }
}
