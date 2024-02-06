package ru.home.io.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
Отображение содержимого текстового файла.
Чтобы воспользоваться этой программой, укажите
имя файла, который требуется просмотреть
Например, чтобы просмотреть файл TEST.TXT,
введите в командной строке следующую команду

java ShowFile TEST.TXT
* */
public class ShowFile {
    public static void main(String[] args) {
        int i;

        // сначала убедиться что имя файла указано
        if (args.length != 1) {
            System.out.println("Использование: ShowFile имя_файла");
            return;
        }
        // В следующем фрагменте кода сначала открывается файл,
        // а затем из него читаются символы до тех пор, пока
        // не встретится признак конца файла
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}