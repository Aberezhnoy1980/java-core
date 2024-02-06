package ru.home.functionInterface.function.apply;

import java.util.function.Function;

public class ApplyAppWithLambda {
    // R apply(T t)
    // Создает на основании объекта ссылка на который используется
    // в качестве параметра новый объект и возвращает ссылку на него
    public static void main(String... args) {

        Function<String, Integer> fun = new StrToLength();

        System.out.println(fun.apply("Hello") + " class implementation");

        Function<String, Integer> fun1 = a -> a.length();

        System.out.println(fun1.apply("Hello") + " lambda implementation");

        Function<String, Integer> fun2 = String::length;

        System.out.println(fun2.apply("World") + " method reference implementation");
    }
}

class StrToLength implements Function<String, Integer> {

    @Override
    public Integer apply(String string) {
        return string.length();
    }
}
