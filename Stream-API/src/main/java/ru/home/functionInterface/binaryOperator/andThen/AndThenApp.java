package ru.home.functionInterface.binaryOperator.andThen;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class AndThenApp {
    // default <V> BiFunction<T,T,V> andThen(Function<? super T,? extends V> after)
    // Этот метод принимает в качестве параметра реализацию Function тип входного параметра которого совместим
    // с типом результата текущей реализации BinaryOperator. В итоге мы получим новую реализацию BiFunction
    // которая будет композицией текущей реализации BinaryOperator и Function. Первым будет вычислен результат
    // текущей реализации BinaryOperator, после чего реализация Function использует результат как входной
    // параметр и на ее основе вернет новое значение.
    public static void main(String[] args) {

        BinaryOperator<String> getSum = (s1, s2) -> s1 + s2;

        Function<String, Integer> getLength = String::length; // s -> s.length()

        BiFunction<String, String, Integer> combine = getSum.andThen(getLength);

        System.out.println(combine.apply("Hello", "World"));

    }
}
