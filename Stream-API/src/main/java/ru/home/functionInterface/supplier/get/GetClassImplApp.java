package ru.home.functionInterface.supplier.get;

import java.util.function.Supplier;

public class GetClassImplApp {
    // T get()
    // Создает объект типа T и возвращает ссылку на него
    public static void main(String... args) {

        Supplier<Integer> counter = new IntegerSequence(0, 10, 1);
        Integer number;
        for (; (number = counter.get()) != null; ) {
            System.out.println(number);
        }
    }
}

class IntegerSequence implements Supplier<Integer> {
    private Integer start;
    private final Integer end;
    private final Integer step;

    public IntegerSequence(Integer start, Integer end, Integer step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public Integer get() {
        if (start > end) {
            return null;
        }
        start += step;
        return (start - step);
    }
}