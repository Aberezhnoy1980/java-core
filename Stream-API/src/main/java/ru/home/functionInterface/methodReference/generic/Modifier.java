package ru.home.functionInterface.methodReference.generic;

@FunctionalInterface
public interface Modifier<T> {

    T change(T obj);
}
