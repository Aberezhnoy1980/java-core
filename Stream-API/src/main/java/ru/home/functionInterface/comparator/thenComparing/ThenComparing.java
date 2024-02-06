package ru.home.functionInterface.comparator.thenComparing;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;

import java.util.Arrays;
import java.util.Comparator;

public class ThenComparing {
    // default Comparator<T> thenComparing(Comparator<? super T> other)
    // Вернет Comparator созданный на основе текущего Comparator и выступающего в качестве параметра.
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        Cat[] cats = mySqlDataBase.getCatsFromDB().toArray(new Cat[0]);

        Comparator<Cat> comp1 = (a, b) -> Integer.compare(a.getAge(), b.getAge());
        Comparator<Cat> comp2 = (a, b) -> a.getName().compareTo(b.getName());
        Comparator<Cat> comp3 = comp1.thenComparing(comp2);

        Arrays.sort(cats, comp3);

        System.out.println(Arrays.toString(cats).replace(",", ""));

        // default <U extends Comparable<? super U>>Comparator<T> thenComparing(Function<? super T,? extends U> keyExtractor)
        // Этот метод принимает в качестве параметра реализацию Function тип входного параметра которого совместим с типом
        // текущей реализации Comparator. Возвращает составной Comparator. Второй компаратор создается с помощью сравнения
        // результатов работы Function. Т.е. Function на основе сравниваемых объектов создает данные другого типа
        // и при вызове метода compareTo() для этих данных (вот для этого U extends Comparable).

        Comparator<Cat> comp4 = (a, b) -> Integer.compare(a.getAge(), b.getAge());
        Comparator<Cat> result = comp4.thenComparing(c -> c.getName());

        Arrays.sort(cats, result);

        // default <U> Comparator<T> thenComparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator)
        // Этот метод принимает в качестве параметра реализацию Function тип входного параметра которого совместим
        // с типом текущей реализации Comparator и Comparator тип входного параметра которого совместим с типом
        // возвращаемого значения Function. Возвращает составной Comparator. Второй компаратор создается как Comparator
        // (второй параметр метода) для результата работы Function (первый параметр метода).

        Comparator<Cat> comp5 = (a, b) -> Integer.compare(a.getAge(), b.getAge());
        Comparator<Cat> resultComp = comp5.thenComparing(ThenComparing::catToString, ThenComparing::compareStringLength);

        Arrays.sort(cats, resultComp);

        System.out.println(Arrays.toString(cats).replace(",", ""));

    }

    public static String catToString(Cat cat) {
        return cat.getName();
    }

    public static int compareStringLength(String a, String b) {
        if (a.length() > b.length()) {
            return 1;
        }
        if (a.length() < b.length()) {
            return -1;
        }
        return 0;
    }
}
