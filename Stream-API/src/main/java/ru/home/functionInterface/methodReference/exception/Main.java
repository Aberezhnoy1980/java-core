package ru.home.functionInterface.methodReference.exception;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String... args) {

        Saver<String> stringSaver = Main::saveToFile;
        try {
            stringSaver.saveTo("Hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void saveToFile(T element) throws IOException {
        PrintWriter printWriter = new PrintWriter(new File("save.txt")); // close or "try with resources"
        printWriter.println(element);
        printWriter.close();
    }
}
