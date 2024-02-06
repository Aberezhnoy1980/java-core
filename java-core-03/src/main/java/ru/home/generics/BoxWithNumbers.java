package ru.home.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxWithNumbers<N extends Number> {
    private final List<N> numbers;

    @SafeVarargs
    public BoxWithNumbers(N... elements) {
        this.numbers = new ArrayList<>(Arrays.asList(elements));
    }

    public double sum() {
        double sum = 0.0;
        for (N e : numbers) {
            sum += e.doubleValue();
        }
        return sum;
    }

    public boolean compareBySum(BoxWithNumbers<?> another) {
        return Math.abs(this.sum() - another.sum()) < 0.00001;
    }
}
