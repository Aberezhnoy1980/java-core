package ru.home.functionInterface.unaryOperator.apply;

import java.util.function.UnaryOperator;

public class ApplyApp {
    // T apply(T t)
    // Производит операцию на основе объекта, ссылка на который выступает в качестве параметра, и возвращает результат такого же типа.
    public static void main(String... args) {

        // Through class implementation
        UnaryOperator<String> customUnaryOperator = new CustomUnaryOperator();


        // Through lambda expression
        UnaryOperator<Integer> intNegativeLambda = a -> -a;

        // Through method reference
        UnaryOperator<Integer> intNegativeMethod = ApplyApp::negative;

        // Results
        System.out.println(customUnaryOperator.apply("Hello world") + " class");
        System.out.println(intNegativeLambda.apply(5) + " lambda");
        System.out.println(intNegativeMethod.apply(3) + " method reference");
    }

    private static Integer negative(Integer integer) {
        return -integer;
    }
}

class CustomUnaryOperator implements java.util.function.UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return s.toLowerCase();
    }
}
