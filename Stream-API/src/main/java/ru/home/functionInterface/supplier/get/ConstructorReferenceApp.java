package ru.home.functionInterface.supplier.get;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ConstructorReferenceApp {
    // Очень часто в качестве реализации Supplier используют ссылку на конструктор класса. Это позволяет реализовать
    // «ленивое» создание объекта. Объект создается только когда вызывается метод get() в реализации этого интерфейса.
    // Если этот метод не вызывается то и объект не создается. Это связанно с тем,что реализация Supplier хранит только ссылку на конструктор.
    public static void main(String... args) {

        Supplier<List<String>> sup = ArrayList::new;

        List<String> strings = sup.get();

        System.out.println(strings);
    }
}
