package ru.home.functionInterface.optional.orElseGet;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.SqliteDB;

import java.util.Optional;

public class OrElseGetApp {
    // T orElseGet(Supplier<? extends T> supplier)
    // Если значение ссылки равно null и нужно сначала создать объект по умолчанию и потом вернуть ссылку на него
    public static void main(String... args) {

        final SqliteDB sqliteDB = new SqliteDB();
        sqliteDB.run();

        Cat[] cats = sqliteDB.getCatsFromSqlite().toArray(new Cat[0]);

        Optional<Cat> cat = findCatByNameOptional(cats, "Torch");

        Cat getCat = cat.orElseGet(Cat::new);

        System.out.println(getCat);
    }

    public static Optional<Cat> findCatByNameOptional(Cat[] cats, String name) {
        Cat tempCat = null;
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                tempCat = cat;
                break;
            }
        }
        return Optional.ofNullable(tempCat);
    }
}
