package ru.home.functionInterface.binaryOperator.apply;

import java.util.function.BinaryOperator;

public class ApplyClassImplApp {
    // T apply(T t1, T t2)
    // Производит операцию на основе объектов, ссылки на которые выступают в качестве параметров,
    // и возвращает результат в виде ссылки такого же типа.
    public static void main(String... args) {

        BinaryOperator<String> stringConcat = new StringConcat(5);

        System.out.println(stringConcat.apply("Hello", "Cat"));
    }
}

class StringConcat implements BinaryOperator<String> {
    private final int minLength;

    public StringConcat(int minLength) {
        super();
        this.minLength = minLength;
    }

    @Override
    public String apply(String s1, String s2) {
        String a = s1.length() >= minLength ? s1 : "";
        String b = s2.length() >= minLength ? s2 : "piska";
        return a + b;
    }
}