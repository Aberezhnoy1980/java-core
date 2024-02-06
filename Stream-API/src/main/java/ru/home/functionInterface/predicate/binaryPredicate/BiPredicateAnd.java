package ru.home.functionInterface.predicate.binaryPredicate;

import java.util.function.BiPredicate;

public class BiPredicateAnd {
    // default BiPredicate<T,U> and(Predicate<? super T, ? super U> other) (or, negate - the same)
    // Возвращает составной предикат (в виде краткого логического И) на основе текущего и того что выступает параметром other.
    public static void main(String[] args) {

        BiPredicate<String, Integer> biPred1 = (a, b) -> a.length() < b + 3;
        BiPredicate<String, Integer> biPred2 = (a, b) -> a.length() > b - 3;

        String text = "Hello";

        System.out.println(biPred1.and(biPred2).test(text, 3));
    }
}
