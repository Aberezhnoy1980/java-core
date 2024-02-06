package ru.home.lesson5.homework5;

import java.util.Arrays;

public class ArraysCalcRace2App {

    static final int size = 10_000;

    public static void main(String[] args) throws InterruptedException {

        method1(size);
        method2(size);
    }

    public static void method1(int size) {
        float[] array = getArray(size);
        final long start = System.currentTimeMillis(); // start countdown

        for (int i = 0; i < array.length; i++) {
            array[i] *= getResult((float) i);
        }

        long time = System.currentTimeMillis() - start; // end countdown
        System.out.println("The total execution time of Method1 is " + time);
    }

    private static float getResult(Float i) {
        return (float) (Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public static void method2(int size) throws InterruptedException {
        float[] array = getArray(size);

        long start = System.currentTimeMillis(); // start countdown
        float[] leftArray = new float[size / 2];
        System.arraycopy(array, 0, leftArray, 0, size / 2);

        float[] rightArray = new float[size / 2];
        System.arraycopy(array, size / 2, rightArray, 0, size / 2);

        final Thread leftIter = new Thread(() -> {
            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] *= getResult((float) i);
            }
        });
        leftIter.start();
        leftIter.join();

        final Thread rightIter = new Thread(() -> {
            for (int i = 0; i < rightArray.length; i++) {
                rightArray[i] = (rightArray[i] + (float) size / 2) * getResult((float) i + size / 2);
            }
        });
        rightIter.start();
        rightIter.join();

        float[] resultMethod2Array = new float[size];
        System.arraycopy(leftArray, 0, resultMethod2Array, 0, size / 2);
        System.arraycopy(rightArray, 0, resultMethod2Array, size / 2, size / 2);
        long time = System.currentTimeMillis() - start; // end countdown

        System.out.println("The total execution time of Method2 is " + time);
    }

    private static float[] getArray(int size) {
        float[] array = new float[size];
        // Arrays.fill(array, 1f) if need to fill array 1
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
}








