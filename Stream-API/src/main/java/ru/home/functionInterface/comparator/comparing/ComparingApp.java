package ru.home.functionInterface.comparator.comparing;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparingApp {
    // static <T,U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor)
    // static <T,U> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator)
    // Эти методы используются для создания Comparator.
    // В случае использования метода с одним параметром (Function) Comparator создается на основании реализации интерфейса
    // Comparable для типа данных которые будут возвращены Function.
    // В случае использования метода с двумя параметрами Comparator создается на основании Comparator (второй параметр)
    // для данных которые вернет реализация Function.
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        List<Cat> cats = mySqlDataBase.getCatsFromDB();

        Function<Cat, String> funGetName = c -> c.getName();

        Comparator<String> nameComp = (a, b) -> a.compareTo(b);

        Comparator<Cat> compositeComp = Comparator.comparing(funGetName, nameComp);

        Cat youngestCat = Collections.min(cats, compositeComp);

        System.out.println(youngestCat);
    }
}
