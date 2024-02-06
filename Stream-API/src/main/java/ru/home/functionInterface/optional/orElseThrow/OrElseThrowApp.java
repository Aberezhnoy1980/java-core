package ru.home.functionInterface.optional.orElseThrow;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.SqliteDB;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OrElseThrowApp {
    //orElseThrow(Supplier<? extends X> exceptionSupplier) - если храниться null то генерировать исключение полученное с помощью параметра метода.
    //orElseThrow() - если храниться null то генерировать исключение NoSuchElementException
    public static void main(String... args) {

        final SqliteDB sqliteDB = new SqliteDB();
        sqliteDB.run();

        Cat[] cats = sqliteDB.getCatsFromSqlite().toArray(new Cat[0]);

        Optional<Cat> result = findCatByNameOptional(cats, "Vaska");

        Cat cat = result.orElseThrow(NoSuchElementException::new);

        System.out.println(cat);

        Optional<Cat> result2 = findCatByNameOptional(cats, "Torch");

        Cat cat2 = result2.orElseThrow();

        System.out.println(cat2);
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
