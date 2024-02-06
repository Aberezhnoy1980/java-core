package ru.home.functionInterface.function.training;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.ToIntFunction;

public class Fifth {
    // Используя примитивную специализацию Function реализуйте функционал который
    // на основе объекта типа java.util.Calendar вернет целое число значение
    // которого равно году хранимому в Calendar.
    public static void main(String... args) {

        Calendar calendar = new GregorianCalendar(2022, Calendar.FEBRUARY, 19);

        ToIntFunction<Calendar> fun = a -> a.get(Calendar.YEAR);

        System.out.println(fun.applyAsInt(calendar));
    }
}
