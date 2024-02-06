package ru.home.io.assertexample.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 Использовать класс BufferedReader для чтения символов с консоли
 */
public class BrRead {
    public static void main(String[] args) throws IOException {
        char c;

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите символы, 'q' - для выхода");

        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
