package ru.home.functionInterface.predicate.notMethod;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.GetListOfCats;
import ru.home.functionInterface.predicate.common.ListOfCat;

import java.util.List;
import java.util.function.Predicate;

public class NotMethodApp {
    // static <T> Predicate<T> not(Predicate<? super T> other)
    // Возвращает предикат в виде логического НЕ на основе предиката используемого в качестве параметра other.
    public static void main(String... args) {

        GetListOfCats getListOfCats = new ListOfCat()::getCatsFromNonStatic;

        List<Cat> cats = getListOfCats.getCats();

        cats.removeIf(Predicate.not(c -> c.getAge() < 6));

        System.out.println(cats);
    }
}
