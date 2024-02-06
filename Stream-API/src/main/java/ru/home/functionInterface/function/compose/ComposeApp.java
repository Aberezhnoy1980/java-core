package ru.home.functionInterface.function.compose;

import java.util.function.Function;

public class ComposeApp {
    // default <V> Function<V,R> compose(Function<? super V,? extends T> before)
    // Возвращает композицию функций. Сначала будет применяться функция выступающая
    // в качестве параметра и к ее результату будет применена текущая функция.
    public static void main(String... args) {

        Function<String, String> fun1 = a -> a.replaceAll("[^A-Za-z]", "");

        Function<String, Integer> fun2 = a -> a.length();

        Function<String, Integer> fun3 = fun2.compose(fun1);

        String text = "Hello world 1234, 621, a 15";

        System.out.println(fun3.apply(text));
    }
}
