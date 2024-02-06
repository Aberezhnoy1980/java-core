package ru.home.functionInterface.consumer.forEach;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachApp {
    // default void forEach(Consumer<? super T> action)
    // Этот метод выполняет действие заданное с помощью реализации Consumer для каждого элемента участвующего в итерации.
    // Стоит обратить внимание на ситуацию изменения с помощью Consumer или элементов участвующих в итерации или
    // структуры данных по которой производится итерации.
    public static void main(String... args) {

        ArrayList<String> strings = new ArrayList<>(List.of("Java", "Fortrun", "Python"));

        Consumer<String> cons = System.out::println;

        strings.forEach(cons);
    }
}
