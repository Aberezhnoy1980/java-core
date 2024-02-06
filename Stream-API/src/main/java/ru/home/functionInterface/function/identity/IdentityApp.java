package ru.home.functionInterface.function.identity;

import java.util.function.Function;

public class IdentityApp {
    // static <T> Function<T,T> identity()
    // Возвращает функцию которая возвращает свой входной параметр.
    public static void main(String... args) {

        Function<Integer, Integer> fun = Function.identity();

        System.out.println(fun.apply(100));
    }
}