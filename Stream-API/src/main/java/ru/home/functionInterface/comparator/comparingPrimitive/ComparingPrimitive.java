package ru.home.functionInterface.comparator.comparingPrimitive;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class ComparingPrimitive {
    // static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor)
    // static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)
    // static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor)
    // Эти методы принимают в качестве параметра реализацию примитивной специализации Functional (соответствующего типа)
    // тип входного параметра которого совместим с типом возвращаемого Comparator. Возвращаемый Comparator создается
    // на основе сравнения примитивных типов которые будут возвращены этими примитивными специализациями.
    // static <T> void sort(List<T> list, Comparator<? super T> c)
    // Данный метод позволит произвести сортировку списка. Критерий сравнения при сортировке задается с помощью
    // реализации Comparator совместимого типа. Часто применяется для сортировки списка объектов пользовательского типа.
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        List<Cat> cats = mySqlDataBase.getCatsFromDB();

        ToIntFunction<Cat> funAgeToInt = c -> c.getAge();

        Comparator<Cat> compositeComp = Comparator.comparingInt(funAgeToInt);

        Collections.sort(cats, compositeComp); // List.sort

        System.out.println(cats);
    }
}
