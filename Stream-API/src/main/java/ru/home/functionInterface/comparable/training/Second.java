package ru.home.functionInterface.comparable.training;

import ru.home.functionInterface.comparable.common.Cat;
import ru.home.functionInterface.comparable.common.MySqlDataBase;

import java.util.List;
import java.util.function.Function;

public class Second {
    // Реализуйте обобщенный метод поиска максимального элемента в массиве объектов.
    // Для этого укажите ограничение для параметра типа этого метода как Comparable<T>.
    // Сигнатура такого метода должна выглядеть следующим образом:
    //<T extends Comparable<T>> T max(T[] array)
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();
        List<Cat> catsFromMySql = mySqlDataBase.getCatsFromMySql();

        System.out.println(getMax(catsFromMySql.toArray(new Cat[0])));
    }

    public static Cat getMax(Cat[] cats) {
        Function<Cat[], Cat> getMax = c -> {
            Cat oldestCat = new Cat();
            for (Cat cat : c) {
                if (cat.compareTo(oldestCat) > 0) {
                    oldestCat = cat;
                }
            }
            return oldestCat;
        };
        return getMax.apply(cats);
    }
}
