package ru.home.lambda.exception;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaverApp {

    public static void main(String... args) {

        Saver saver = (obj) -> {
            File file = new File("save1.txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(obj.toString());
            printWriter.close();
        };

        try {
            saver.save("Hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
