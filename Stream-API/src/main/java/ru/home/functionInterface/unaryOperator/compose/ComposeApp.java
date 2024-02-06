package ru.home.functionInterface.unaryOperator.compose;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ComposeApp {
    // default <V> Function<V,T> compose(Function<? super V,? extends T> before)
    // Возвращает композицию реализации UnaryOperator и Function. Сначала будет выполнена текущая реализация
    // Function а результат будет использован в качестве входящего параметра реализации UnaryOperator.
    public static void main(String... args) {

        Function<String, Integer> getStringLength = String::length;

        UnaryOperator<Integer> doubleLength = i -> i * 2;

        Function<String, Integer> composeResult = doubleLength.compose(getStringLength);

        System.out.println(composeResult.apply("hello"));
    }
}
