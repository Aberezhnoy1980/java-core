package ru.home.functionInterface.comparator.reversed;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;
import ru.home.functionInterface.comparator.compare.CompareApp;

import java.util.Arrays;
import java.util.Comparator;

public class ReversedApp {
    // default Comparator<T> reversed()
    // Этот метод возвращает «обратный» Comparator на основании текущего. Под обратным Comparator
    // подразумевается возвращающий противоположный результат сравнения. Т.е. если текущий
    // возвращает положительное число то обратный отрицательное и т. д. Обратный Comparator
    // позволяет проводить сортировку по убыванию в случае необходимости.
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        Cat[] cats = mySqlDataBase.getCatsFromDB().toArray(new Cat[0]);

        Comparator<Cat> directComparator = ReversedApp::CatAgeCompare;

        Comparator<Cat> reversedComparator = directComparator.reversed();

        Arrays.sort(cats, reversedComparator);

        for (Cat c : cats) {
            System.out.print(c);
        }
    }

    private static int CatAgeCompare(Cat cat, Cat cat1) {
        if (cat.getAge() > cat1.getAge()) {
            return 1;
        }
        if (cat.getAge() < cat1.getAge()) {
            return - 1;
        }
        return 0;
    }
}
