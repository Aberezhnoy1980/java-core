package ru.home.functionInterface.optional.common;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface GetCats {

    List<Cat> getCats();

    static SqliteDB connectDB() {
        final SqliteDB sqliteDB = new SqliteDB();
        sqliteDB.run();
        return sqliteDB;
    }

    static Optional<Cat> findCatByNameOptional(Cat[] cats, String name) {
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
