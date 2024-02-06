package ru.home.lambda.exception;

import java.io.IOException;

@FunctionalInterface
public interface Saver {

    void save(Object obj) throws IOException;
}
