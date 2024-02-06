package ru.home.functionInterface.comparable;

import ru.home.functionInterface.comparable.common.Cat;
import ru.home.functionInterface.comparable.common.Dao;
import ru.home.functionInterface.comparable.common.GetListOfCats;
import ru.home.functionInterface.comparable.common.MySqlDataBase;

import java.util.List;

public class ComparableApp {
    // int compareTo(T o)
    // Выполняет сравнение текущего объекта с объектом по ссылке используемой в качестве параметра.
    // Если текущий объект больше (по выбранному вами критерию) то необходимо вернуть положительное число.
    // В случае когда текущий объект меньше, то отрицательное. Ноль стоит вернуть в случае равенства этих объектов.

    public static void main(String[] args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        GetListOfCats<List<Cat>> getCatsFromLambda = () -> new Dao().getCatsFromLambda();
//        GetListOfCats<List<Cat>> getCatsFromNonStatic = new Dao()::getCatsFromNonStatic;
//        GetListOfCats<List<Cat>> getCatsFromStatic = Dao::getCatsFromStatic;
//
//        List<Cat> catsFromCLassThroughLambda = getCatsFromLambda.getCats();
//        List<Cat> catsFromCLassThroughStatic = getCatsFromStatic.getCats();
//        List<Cat> catsFromCLassThroughNonStatic = getCatsFromNonStatic.getCats();
//
//        System.out.println(catsFromCLassThroughNonStatic);
//
//        System.out.println(mySqlDataBase.getCatsFromMySql());

        Cat a = new Cat("Umka", 12);
        Cat b = new Cat("Luska", 5);
        Cat c = new Cat("Kuzia", 2);
        Cat d = new Cat("Umka", 12);
        Cat e = new Cat("Barsic", 12);

        System.out.println(sgn(a.compareTo(b)) == -sgn(b.compareTo(a)));
        System.out.println(a.compareTo(b) > 0 && b.compareTo(c) > 0);
        System.out.println(a.compareTo(d) == 0 && (sgn(a.compareTo(c)) == sgn(d.compareTo(c))));

        System.out.println(a.equals(d) == true && a.compareTo(d) == 0);
        System.out.println(a.equals(b) == false && a.compareTo(b) != 0);
        System.out.println(a.equals(e) == false && a.compareTo(e) != 0);
    }

    public static int sgn(int x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }
        return 0;
    }
}
