package ru.home.lambda.methodImpl;

import ru.home.lambda.fieldImpl.Summator;

public class MethodImplApp {

    public static void main(String... args) {

        Summator summator = getIntegerSummator(new int[]{7, 8, 9});

        System.out.println(summator.getSum());

    }

    public static Summator getIntegerSummator(int[] arr) {
        Summator summator = () -> {
            int sum = 0;
            for (int e : arr) {
                sum += e;
            }
            return sum;
        };
        return summator;
    }
}
