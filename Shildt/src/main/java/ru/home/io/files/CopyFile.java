package ru.home.io.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Копирование файла.
чтобы воспользоваться этой программой, укажите
имена исходного и целевого файлов.
Например, чтобы скопировать файл FIRST.TXT
в файл SECOND.TXT, введите в командной строке
следующую команду:

java CopyFile FIRST.TXT SECOND.TXT
*/
public class CopyFile {
    public static void main(String[] args) {
        int i;

        // сначала убедиться, что указаны имена обоих файлов
        if (args.length != 2) {
            System.out.println("Использование: CopyFile откуда куда");
        }

        // открыть два файла и управлять ими в операторе try
        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1], true)) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
