package ru.home.functionInterface.optional.transformation;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.GetCats;

import java.util.Optional;

public class MapApp {
    // Optional<U> map(Function<? super T,? extends U> mapper)
    // Если значение ссылки в Optional не равно null то создается новый Optional на основании значения ссылки.
    // В противном случае вернется пустой Optional.
    public static void main(String... args) {

        Cat[] cats = GetCats.connectDB().getCatsFromSqlite().toArray(new Cat[0]);

        Optional<Cat> result = GetCats.findCatByNameOptional(cats, "Tishka");

        String catColor = result.map(c -> c.getColor()).orElseGet(() -> "Cat not found");

        System.out.println(catColor);
    }
}
