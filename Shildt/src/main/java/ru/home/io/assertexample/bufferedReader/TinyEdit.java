package ru.home.io.assertexample.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Простейший текстовый редактор
public class TinyEdit {
    public static void main(String[] args) throws IOException {
        // Создать поток ввода типа BufferedReader,
        // используя стандартный поток ввода System.in
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] strings = new String[100];
        System.out.println("Введите строки текста, 'stop' для завершения");
        for (int i = 0; i < 100; i++) {
            strings[i] = br.readLine();
            if(strings[i].equals("stop")) break;
        }

        System.out.println("Содержимое вашего файла: ");
        // Вывести текстовые строки
        for (int i = 0; i < 100; i++) {
            if (strings[i].equals("stop")) break;
            System.out.println(strings[i]);
        }
    }
}
