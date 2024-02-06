package ru.home.functionInterface.methodReference.exception;

import java.io.IOException;

@FunctionalInterface
public interface Saver<T> {

    void saveTo(T element) throws IOException;
}
