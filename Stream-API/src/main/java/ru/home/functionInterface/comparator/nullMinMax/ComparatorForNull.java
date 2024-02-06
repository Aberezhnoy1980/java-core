package ru.home.functionInterface.comparator.nullMinMax;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorForNull {
    // static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator)
    // static <T> Comparator<T> nullsLast(Comparator<? super T> comparator)
    // Эти методы принимают в качестве параметра реализацию Comparator и возвращают
    // «дружественный» к значению null Comparator. Этот Comparator сначала проверяет ссылки
    // на null и если обе ссылки не равны null вызывает Comparator который был параметром
    // метода. Если же хотя бы один из параметров равен null то возвращает результат вида:
    // - nullsFirst значение null всегда меньше
    // - nullsLast значение null всегда больше
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        List<Cat> cats = mySqlDataBase.getCatsFromDB();

        cats.add(null);

        Comparator<Cat> comp = (a ,b) -> a.getAge().compareTo(b.getAge());

//        Cat youngestCat = Collections.min(cats, comp);

//        System.out.println(youngestCat);

        Comparator<Cat> nullComp = Comparator.nullsLast(comp);

        Cat youngestNullFriendlyCat = Collections.min(cats, nullComp);

        System.out.println(youngestNullFriendlyCat);
    }
}
