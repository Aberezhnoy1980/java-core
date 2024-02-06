package ru.home.functionInterface.predicate.binaryPredicate;

import java.util.function.BiPredicate;

public class BiPredicateTest {
    // boolean test(T t, U u)
    // Проверяет удовлетворяет ли объект по ссылке t и объект по ссылке u заданному условию.
    // Если да то метод должен вернуть true, в противном случае false.
    public static void main(String[] args) {

        BiPredicate<String, Integer> biPred = (a, b) -> a.length() > b;

        System.out.println((biPred.test("Hello", 10)));

    }
}

