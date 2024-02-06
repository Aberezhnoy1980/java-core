package ru.home.generics.homework;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {
    public static void main(String... args) {
        Byte[] byteArray = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(arrayConvertToList(byteArray));
    }

    public static <T> List<T> arrayConvertToList(T[] array) {
        final ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
