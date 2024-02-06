package ru.home.functionInterface.comparator.compare;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareApp {
    // int compare(T o1, T o2)
    // Возвращает положительное число в случае если объект по первой ссылке больше объекта по второй ссылке.
    // Возвращает отрицательное число в случае если объект по второй ссылке больше объекта первого.
    // Возвращает ноль если в случае равенства двух объектов по ссылкам.
    public static void main(String[] args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        List<Cat> cats = mySqlDataBase.getCatsFromDB();

        Cat[] catsArray = cats.toArray(new Cat[0]);

        CatAgeComparator comparator = new CatAgeComparator();

        System.out.println(comparator.compare(cats.get(0), cats.get(1)) == -comparator.compare(cats.get(1), cats.get(0)));
        System.out.println(comparator.compare(cats.get(0), cats.get(1)) > 0 && comparator.compare(cats.get(1), cats.get(4)) > 0 && comparator.compare(cats.get(0), cats.get(4)) > 0);
        System.out.println(comparator.compare(cats.get(1), cats.get(3)) == 0 && (comparator.compare(cats.get(1), cats.get(0)) < 0 && comparator.compare(cats.get(3), cats.get(0)) < 0));

        Arrays.sort(catsArray, comparator);

        System.out.println(Arrays.toString(catsArray).replace(",", ""));

        Integer[] array = {5, 0, -3, 2, -1, 4};

        Comparator<Integer> integerComparator = (a, b) -> Math.abs(a) - Math.abs(b);

        Arrays.sort(array, integerComparator);

        System.out.println(Arrays.toString(array));
    }

    static class CatAgeComparator implements Comparator<Cat> {
        @Override
        public int compare(Cat c1, Cat c2) {
            if (c1.getAge() > c2.getAge()) {
                return 1;
            }
            if (c1.getAge() < c2.getAge()) {
                return -1;
            }
            return 0;
        }
    }

}
