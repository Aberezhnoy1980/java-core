package ru.home.functionInterface.unaryOperator.identity;

import java.util.function.UnaryOperator;

public class IdentityApp {
    // static <T> UnaryOperator<T> identity()
    // Этот статический метод возвращает реализацию UnaryOperator которая возвращает значение переданное в качестве параметра.
    public static void main(String[] args) {

        UnaryOperator<Integer> identity = UnaryOperator.identity();

        System.out.println(identity.apply(5));
    }
}
