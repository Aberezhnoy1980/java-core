package ru.home.functionInterface.supplier.primitive;

import java.util.Arrays;
import java.util.function.IntSupplier;

public class PrimitiveApp {
    // BooleanSupplier - для создания значений типа boolean
    // IntSupplier - для создания значений типа int
    // LongSupplier - для создания значений типа long
    // DoubleSupplier - для создания значений типа double
    public static void main(String... args) {

        IntSupplier intSup = new RandomGenerator(10, 20);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = intSup.getAsInt();
        }

        System.out.println(Arrays.toString(array));

    }
}

class RandomGenerator implements IntSupplier {
    private final int min;
    private final int max;

    public RandomGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getAsInt() {
        return (int) (min + (Math.random() * (max - min)));
    }
}