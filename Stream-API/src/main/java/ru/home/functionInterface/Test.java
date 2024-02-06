package ru.home.functionInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) throws IOException {

        String url = "jdbc:mysql://localhost:3306/stream_api?createDatabaseIfNotExist=true";

        System.out.println(url.substring(28, 38));

        Path path = Paths.get("/Users/alex/Documents/Study/Practice/Java/java_core/Stream-API/src/main/java/ru/home/functionInterface/comparator/common/params");
        String read = Files.readAllLines(path).get(0);
        String read1 = Files.readAllLines(path).get(1);
        String read2= Files.readAllLines(path).get(2);

        System.out.println(read);
        System.out.println(read1);
        System.out.println(read2);

    }
}
