package ru.home.functionInterface.optional.transformation;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.GetCats;

import java.util.Optional;

public class IfPresentOrElse {
    // void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
    // Если значение ссылки не равно null то выполнить действие с использованием ссылки, в противном случае выполнить альтернативное действие.
    public static void main(String... args) {

        Cat[] cats = GetCats.connectDB().getCatsFromSqlite().toArray(new Cat[0]);

        Optional<Cat> result = GetCats.findCatByNameOptional(cats, "Fedik");

        result.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
    }
}
