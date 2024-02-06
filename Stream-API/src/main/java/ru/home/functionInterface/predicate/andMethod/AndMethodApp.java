package ru.home.functionInterface.predicate.andMethod;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.GetListOfCats;
import ru.home.functionInterface.predicate.common.ListOfCat;

import java.util.List;
import java.util.function.Predicate;

public class AndMethodApp {
    // default Predicate<T> and(Predicate<? super T> other)
    // Возвращает составной предикат (в виде краткого логического И)
    // на основе текущего и того что выступает параметром other.
    public static void main(String... args) {

        GetListOfCats getListOfCats = new ListOfCat()::getCatsFromNonStatic;

        List<Cat> cats = getListOfCats.getCats();

        GetListOfCats getCatsFromLambda = () -> new ListOfCat().getCatsFromLambda();

        List<Cat> cats1 = getCatsFromLambda.getCats();

        Predicate<Cat> pr1 = cat -> cat.getAge() < 5;

        Predicate<Cat> pr2 = cat -> cat.getName().startsWith("K");

        cats.removeIf(pr1.and(pr2));

        System.out.println(cats);

        Predicate<Cat> pr3 = AndMethodApp::ageTest;

        Predicate<Cat> pr4 = AndMethodApp::nameTest;

        cats1.removeIf(pr3.and(pr4));

        System.out.println(cats1);
    }

    public static boolean ageTest(Cat cat) {
        return cat.getAge() % 2 == 0;
    }

    public static boolean nameTest(Cat cat) {
        return !cat.getName().startsWith("L");
    }
}
