package ru.home.io.assertexample.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Чтение символьных строк с консоли средствами
класса BufferedReader
*/
public class BRReadLines {
    public static void main(String[] args) throws IOException {
        // Создать поток ввода типа BufferedReader,
        // используя стандартный поток ввода System.in
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        System.out.println("Введите текст, 'stop' для завершения");

        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));
    }
}
