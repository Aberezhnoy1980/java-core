package ru.home.functionInterface.comparator.training;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fifth {
    // Создайте Comparator<File> для сортировке списка текстовых файлов по количеству знаков препинания в них.
    // При решении принять, что знаки препинания ограниченны символами {, . - ? !} и символ пробел.
    public static void main(String... args) throws IOException {

        String prefix = "/Users/alex/Documents/Study/Practice/Java/java_core/Stream-API/src/main/java/ru/home/functionInterface/comparator/training/";
        String text2 = "Test data.1/-,";
        String text3 = "New data, new file!.....";
        String text1 = "Another data,-?..!!?..";

        // Create files
        File file1 = new File(prefix + "text1.txt");
        FileWriter writer = new FileWriter(file1);
        writer.write(text1);
        writer.close();

        File file2 = new File(prefix + "text2.txt");
        FileOutputStream out = new FileOutputStream(file2);
        out.write(text2.getBytes());
        out.close();

        File file3 = new File(prefix + "text3.txt");
        Files.write(Paths.get(file3.toURI()), text3.getBytes());

        // Move files to list
        List<File> files = new ArrayList<>(List.of(file1, file2, file3));

        // Comparator
        Comparator<File> fileComp = (a, b) -> {
            try {
                return compareFiles(a, b);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        files.sort(fileComp);

        for (File f : files) {
            System.out.println(f.getName() + " characters count is " + Files.readString(f.toPath()).replaceAll("[A-Za-z]", "").length());
        }

    }

    private static int compareFiles(File f1, File f2) throws IOException {
        int a = Files.readString(f1.toPath()).replaceAll("[A-Za-z]", "").length();
        int b = Files.readString(f2.toPath()).replaceAll("[A-Za-z]", "").length();
        return Integer.compare(a, b);
    }
}
