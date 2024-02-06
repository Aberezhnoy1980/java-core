package ru.home.functionInterface.supplier.training;

import java.util.function.IntSupplier;

public class Third {
    // Реализуйте IntSupplier последовательно возвращающий элемент из массива целых чисел.
    public static void main(String... args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int j : array) {
            IntSupplier intSup = () -> j;
            System.out.println(intSup.getAsInt());
        }
    }
}
