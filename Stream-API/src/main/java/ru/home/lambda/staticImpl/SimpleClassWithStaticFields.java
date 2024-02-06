package ru.home.lambda.staticImpl;

import ru.home.lambda.fieldImpl.Summator;

public class SimpleClassWithStaticFields {

    private static int[] arr = new int[]{1, 2, 3};

    private static final Summator summator = () -> getSum(arr);

    public static void setArr(int[] arr) {
        SimpleClassWithStaticFields.arr = arr;
    }

    public static Summator getSummator() {
        return summator;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
