package ru.home.generics.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapElementsInList {

    public static void main(String... args) {

        ArrayList<Float> numbers = buildListOfNumbers(1.5f, 2.67f, 3.34f, 4.23f, 5.54f);
        swapElementsByIndex(numbers, 0, 1);
        System.out.println(numbers);

        ArrayList<Integer> strings = new ArrayList<>(Arrays.asList(1, 1, 2, 3));
        swapElementsByValue(strings, 2, 1);
        System.out.println(strings);
    }

    @SafeVarargs
    public static <N extends Number> ArrayList<N> buildListOfNumbers(N... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <N extends Number> void swapElementsByIndex(List<N> list, int idx1, int idx2) {
        N tempElement = list.get(idx1);

        list.add(idx1, list.get(idx2));
        list.remove(idx1 + 1);
        list.add(idx2, tempElement);
        list.remove(idx2 + 1);
    }

    public static <T> void swapElementsByValue(List<T> list, T value1, T value2) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value1)) {
                list.add(i, value2);
                list.remove(i + 1);
                int k = i + 1;
                if (i == list.size() - 1) k = 0;
                for (int j = k; j < list.size(); j++) {
                    if (list.get(j).equals(value2)) {
                        list.add(j, value1);
                        list.remove(j + 1);
                        break;
                    } else {
                        for (int h = 0; h < k - 1; h++) {
                            if (list.get(h).equals(value2)) {
                                list.add(h, value1);
                                list.remove(h + 1);
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
    }
}