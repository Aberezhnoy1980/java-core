package ru.home.functionInterface.optional.transformation;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.GetCats;

import java.util.Optional;

public class IfPresentApp {
    // void ifPresent(Consumer<? super T> action)
    // Если значение ссылки равно не равно null то выполнить действие с использованием ссылки, в противном случае ничего не делать.
    public static void main(String... args) {

        Cat[] cats = GetCats.connectDB().getCatsFromSqlite().toArray(new Cat[0]);

        Optional<Cat> result = GetCats.findCatByNameOptional(cats, "Tishka");

        result.ifPresent(c -> System.out.println(c));
    }
}
