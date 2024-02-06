package ru.home.lambda.fieldImpl;

public class SimpleClass {

    private int[] arr;

    private final Summator summator = () -> {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    };

    public SimpleClass(int[] arr) {
        super();
        this.arr = arr;
    }

    public Summator getSummatorInstance() {
        return this.summator;
    }
}
