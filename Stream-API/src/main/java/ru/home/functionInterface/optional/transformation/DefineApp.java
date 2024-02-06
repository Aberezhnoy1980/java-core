package ru.home.functionInterface.optional.transformation;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.GetCats;

import java.util.List;
import java.util.Optional;

public class DefineApp {
    // Когда на основе искомых объектов нужно создать новые данные можно использовать методы трансформации Optional.
    // Но перед их изучением сначала стоит рассмотреть что значит генерация новых данных на основании получаемого объекта.
    public static void main(String[] args) {

        List<Cat> cats = GetCats.connectDB().getCatsFromSqlite();

        Optional<Cat> result = GetCats.findCatByNameOptional(cats.toArray(new Cat[0]), "Pidar");

        Cat cat = result.orElseGet(Cat::new);

        String catColor = cat.getColor();

        System.out.println(catColor);
    }
}
