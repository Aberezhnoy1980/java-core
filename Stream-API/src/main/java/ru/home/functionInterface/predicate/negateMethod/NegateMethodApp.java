package ru.home.functionInterface.predicate.negateMethod;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.GetListOfCats;
import ru.home.functionInterface.predicate.common.ListOfCat;

import java.util.List;
import java.util.function.Predicate;

public class NegateMethodApp {
    // default Predicate<T> negate()
    // Возвращает предикат в виде логического НЕ на основании текущего предиката
    public static void main(String[] args) {

        GetListOfCats getListOfCats = ListOfCat::getCatsFromStatic;

        List<Cat> cats = getListOfCats.getCats();

        Predicate<Cat> negate = c -> c.getAge() % 2 != 0;

        cats.removeIf(negate.negate());

        System.out.println(cats);
    }
}
