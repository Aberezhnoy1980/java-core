package ru.home.functionInterface.consumer.andThan;

import java.util.function.Consumer;

public class AndThanApp {
    // default Consumer<T> andThen(Consumer<? super T> after)
    // Этот метод принимает в качестве параметра реализацию Consumer тип входного параметра которого совместим с типом
    // текущей реализации. В итоге мы получим новую реализацию Consumer которая будет композицией текущей и той что
    // используется в качестве параметра. Первой будет выполнена текущая реализация, после чего используемая в качестве параметра.
    public static void main(String... args) {

        Consumer<String> cons1 = a -> System.out.print("*" + a);

        Consumer<String> cons2 = a -> System.out.println("*");

        Consumer<String> consComposite = cons1.andThen(cons2);

        consComposite.accept("Hello");

    }
}
