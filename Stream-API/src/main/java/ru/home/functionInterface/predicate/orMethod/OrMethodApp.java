package ru.home.functionInterface.predicate.orMethod;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.SqliteDataBase;

import java.util.List;
import java.util.function.Predicate;

public class OrMethodApp {
    // default Predicate<T> or(Predicate<? super T> other)
    // Возвращает составной предикат (в виде краткого логического ИЛИ)
    // на основе текущего и того что выступает параметром other.
    public static void main(String[] args) {

        final SqliteDataBase sqliteDataBase = new SqliteDataBase();
        sqliteDataBase.run();

        List<Cat> cats = sqliteDataBase.getCatsFromDB();

        Predicate<Cat> pr1 = c -> c.getAge() < 5;

        Predicate<Cat> pr2 = c -> c.getAge() > 10;

        cats.removeIf(pr1.or(pr2));

        System.out.println(cats);
    }
}
