package ru.home.functionInterface.optional.orElse;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.SqliteDB;

import java.util.Optional;

public class OrElse {
    // T orElse (T other)
    // Если значение ссылки равно null и нужно вернуть ссылку на существующий объект по умолчанию
    public static void main(String... args) {

        SqliteDB sqliteDB = new SqliteDB();
        sqliteDB.run();

        Cat[] cats = sqliteDB.getCatsFromSqlite().toArray(new Cat[0]);

        Cat defaultCat = new Cat("Default", "Default");

        Optional<Cat> optCat = findCatByNameOptional(cats, "Perec");

        Cat cat = optCat.orElse(defaultCat);

        System.out.println(cat);
    }

    public static Optional<Cat> findCatByNameOptional(Cat[] cats, String name) {
        Cat optCat = null;
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                optCat = cat;
                break;
            }
        }
        return Optional.ofNullable(optCat);
    }
}
