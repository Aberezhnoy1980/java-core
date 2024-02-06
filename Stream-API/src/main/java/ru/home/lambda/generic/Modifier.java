package ru.home.lambda.generic;

@FunctionalInterface
public interface Modifier<T> {

    T modification(T element);
}
