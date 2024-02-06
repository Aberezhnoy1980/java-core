package ru.home.functionInterface.comparable;

import java.util.Comparator;
import java.util.function.Function;

public class ComparatorApp {
    // static <T,U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor)
    // Comparator создается на основании реализации интерфейса Comparable для типа данных которые будут возвращены Function.
    // Таким образом реализация Function должна возвращать объект класса реализующий Comparable (для них установлено отношение естественного порядка).
    public static void main(String... args) {

        Function<String, Integer> fun = String::length;

        Comparator<String> cmp = Comparator.comparing(fun);

        System.out.println(cmp.compare("Java", "Python"));
    }
}
