package ru.home.functionInterface.comparator.training;

import ru.home.functionInterface.comparator.common.Cat;
import ru.home.functionInterface.comparator.common.MySqlDataBase;

import java.util.Arrays;
import java.util.Comparator;

public class First {
    // С помощью реализации Comparator<Cat> отсортируйте массив Cat в порядке возрастания длинны имени.
    // Т.е. сначала должны идти коты чье имя самое короткое.
    public static void main(String... args) {

        MySqlDataBase mySqlDataBase = new MySqlDataBase();
        mySqlDataBase.run();

        Cat[] cats = mySqlDataBase.getCatsFromDB().toArray(new Cat[0]);

        Comparator<Cat> nameLength = (a, b) -> a.getName().length() - b.getName().length();

//        Comparator<Cat> reversedNameLength = (a, b) -> b.getName().length() - a.getName().length();

        Comparator<Cat> reverseNameLength = nameLength.reversed();

        Arrays.sort(cats, reverseNameLength);

//        Arrays.sort(cats, reversedNameLength);

        System.out.println(Arrays.toString(cats).replace(",", ""));
    }
}
