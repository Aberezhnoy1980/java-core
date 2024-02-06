package ru.home.functionInterface.unaryOperator.andThen;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AndThanApp {
    // default <V> Function<T,V> andThen(Function<? super T,? extends V> after))
    // Возвращает композицию реализации UnaryOperator и Function. Сначала будет выполнена текущая
    // реализация UnaryOperator а результат будет использован в качестве входящего параметра реализации Function.
    public static void main(String... args) {

        UnaryOperator<String> cutSpace = s -> s.strip();

        Function<String, Integer> getStringLength = s -> s.length();

        Function<String, Integer> compositeCutAndLength = cutSpace.andThen(getStringLength);

        System.out.println(compositeCutAndLength.apply(" hello "));
    }
}
