package ru.home.functionInterface.function.primitive;

import java.util.Date;
import java.util.function.DoubleToIntFunction;
import java.util.function.LongFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class PrimitiveApp {
    // LongFunction<R>
    // Использует в качестве параметра тип long и возвращает значение типа R.
    public static void main(String... args) {

        LongFunction<Date> fun = a -> new Date(a); // Data::new

        System.out.println(fun.apply(4_00_000_000_000L));

        // ToIntFunction<T>
        // Создает значение типа int на основании объекта по ссылке типа T
        // Внимание названия абстрактных методов формируется по принципу: applyAsТип примитивного значения (тип результата)
        // Так например в ToIntFunction абстрактный метод называется applyAsInt
        ToIntFunction<String> fun1 = String::hashCode;

        System.out.println(fun1.applyAsInt("Hello"));

        // DoubleToIntFunction
        // Создает значение типа int на основании значения типа double
        // Внимание названия абстрактных методов формируется по принципу: applyAsТип примитивного значения (тип результата)
        // Так например в LongToIntFunction абстрактный метод называется applyAsInt
        DoubleToIntFunction fun2 = PrimitiveApp::convert;

        System.out.println(fun2.applyAsInt(1.99));

        // ToIntBiFunction<T, U>
        // На основания объектов типа T и U создается значение типа int
        // Внимание названия абстрактных методов формируется по принципу: applyAsТип примитивного значения (тип результата)
        // Так например в ToIntBiFunction абстрактный метод называется applyAsInt
        ToIntBiFunction<Character, Character> fun3 = Integer::sum;
        System.out.println(fun3.applyAsInt('a', 'b'));

    }

    public static int convert(double num) {
        return (int) num;
    }
}
