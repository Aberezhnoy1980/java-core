package ru.home.functionInterface.optional.examples;

import ru.home.functionInterface.optional.common.Cat;
import ru.home.functionInterface.optional.common.SqliteDB;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ExampleApp {
    // Optional.empty() - объект точно отсутствует
    // Optional.of(T obj) - объект присутствует и он точно не null
    // Optional.ofNullable(T obj) - объект присутствует, но возможно он null
    public static void main(String[] args) {

        final SqliteDB sqliteDB = new SqliteDB();
        sqliteDB.run();

        Cat[] cats = sqliteDB.getCatsFromSqlite().toArray(new Cat[0]);

        System.out.println(Arrays.toString(cats));

        Cat findCat = findCatByName(cats, "Vaska");
        if (findCat != null) {
            System.out.println(findCat);
        }

        try {
            Cat findCatEx = findByNameEx(cats, "Vaska");
            System.out.println(findCatEx);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("cat not found");
        }

        Optional<Cat> findCatOptional = findByNameOptional(cats, "Torch");
        if (findCatOptional.isPresent()) {
            Cat cat = findCatOptional.get();
            System.out.println(cat);
        } else {
            System.out.println("Cat not found");
        }

        Cat cat2 = findCatOptional.orElseThrow(() -> new NoSuchElementException("Cat not found"));
        System.out.println(cat2);

    }

    // null return example
    public static Cat findCatByName(Cat[] cats, String name) {
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                return cat;
            }
        }
        return null;
    }

    // exception generation example
    public static Cat findByNameEx(Cat[] cats, String name) throws NoSuchElementException {
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                return cat;
            }
        }
        throw new NoSuchElementException();
    }

    // Optional option
    public static Optional<Cat> findByNameOptional(Cat[] cats, String name) {
        Cat result = null;
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                result = cat;
                break;
            }
        }
        return Optional.ofNullable(result);
    }
}
