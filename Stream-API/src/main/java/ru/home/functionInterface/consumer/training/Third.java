package ru.home.functionInterface.consumer.training;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Third {
    //Реализуйте BiConsumer<String, File> добавляющий строку в конец файла указанного в качестве параметра.
    public static void main(String... args) throws IOException {

        // Create and write files
        String prefix = "/Users/alex/Documents/Study/Practice/Java/java_core/Stream-API/src/main/java/ru/home/functionInterface/consumer/training/";
        String text1 = "Text1";
        String text2 = "Text2";
        String text3 = "Text3";
        String textForAppend = "\ntext from Consumer!";

        File file1 = new File(prefix + "file1.txt");
        Files.write(Paths.get(file1.toURI()), text1.getBytes());

        File file2 = new File(prefix + "file2.txt");
        Files.write(Paths.get(file2.toURI()), text2.getBytes());

        File file3 = new File(prefix + "file3.txt");
        Files.write(Paths.get(file3.toURI()), text3.getBytes());

        // Move files to list
        List<File> files = new ArrayList<>(List.of(file1, file2, file3));

        // Create Consumer
        BiConsumer<String, File> appendTextToFile = (s, f) -> {
            try {
                appendText(s, f);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        };

        Consumer<File> appendTextToFileInForEach = f -> {
            try {
                Files.write(Paths.get(f.toURI()), "\nText from consumer in foEach".getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        };

        appendTextToFile.accept(textForAppend, file1);

//        files.forEach(appendTextToFileInForEach);

    }

    private static void appendText(String s, File file) throws IOException {
        Files.write(Paths.get(file.toURI()), s.getBytes(), StandardOpenOption.APPEND);
    }
}
