package ru.home.functionInterface.predicate.testMethod;

import ru.home.functionInterface.predicate.common.Cat;
import ru.home.functionInterface.predicate.common.GetListOfCats;
import ru.home.functionInterface.predicate.common.ListOfCat;
import ru.home.functionInterface.predicate.common.SqliteDataBase;

import java.util.List;

public class TestMethodApp {
    // boolean test(T t)
    // Проверяет удовлетворяет ли объект по ссылке t заданному условию.
    // Если да то метод должен вернуть true, в противном случае false.
    public static void main(String... args) {

        SqliteDataBase sqliteDataBase = new SqliteDataBase();
        sqliteDataBase.run();

        List<Cat> cats = sqliteDataBase.getCatsFromDB();

        GetListOfCats getCatsFromStatic = ListOfCat::getCatsFromStatic;

        List<Cat> cats1 = getCatsFromStatic.getCats();

        GetListOfCats getCatsFromNonStatic = new ListOfCat()::getCatsFromNonStatic;

        List<Cat> cats2 = getCatsFromNonStatic.getCats();

        GetListOfCats getCatsFromLambda = () -> new ListOfCat().getCatsFromLambda();

        List<Cat> cats3 = getCatsFromLambda.getCats();

        List<Cat> cats4 = ListOfCat.cats1;

        cats.removeIf(cat -> cat.getAge() > 2);

        System.out.println(cats);

        cats4.removeIf(TestMethodApp::testCat);

        System.out.println(cats4);

        cats1.removeIf(cat -> cat.getName().endsWith("a"));

        System.out.println(cats1);

    }

    public static boolean testCat(Cat cat) {
        return cat.getAge() < 6;
    }
}
