package ru.home.functionInterface.comparator.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Third {
    // Создайте реализацию Comparator<Integer> для сортировки списка целых чисел. Но сравнение должно выполняться
    // на основание суммы первой и последней цифры числа.
    // Т.е например список чисел подобного вида [62,2000,306,55] должен быть отсортирован как [2000, 62, 306,55].
    public static void main(String... args) {

        List<Integer> ints = new ArrayList<>(List.of(62, 2000, 306, 55, 9));

        Function<Integer, Integer> intConverter = Third::convertInteger;

        Comparator<Integer> comp = Integer::compareTo;

        Comparator<Integer> compositeComp = Comparator.comparing(intConverter, comp);

        ints.sort(compositeComp);

        System.out.println(ints);

        ints.sort(compositeComp.reversed());

        System.out.println(ints);
    }

    public static Integer convertInteger(Integer i) {
        String strI = Integer.toString(i);
        int firstNum = Integer.parseInt(strI.substring(0, 1));
        int lastNum = Integer.parseInt(strI.substring(strI.length() - 1));
        int targetNum = firstNum + lastNum;
        if (strI.length() == 1) return i;
        return targetNum;
    }
}
