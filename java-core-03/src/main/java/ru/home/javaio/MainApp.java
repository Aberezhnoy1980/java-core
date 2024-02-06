package ru.home.javaio;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
//        final File file = new File("java-core-03/src/main/java/ru/home/javaio/file1.txt");
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.exists());
//        System.out.println(file.getAbsoluteFile().getName());
//        System.out.println(file.length());
//        final File directory = new File("java-core-03/src/main/java/ru/home/javaio/directory");
//        File[] files = directory.listFiles(pathname -> file.getName().startsWith("f"));
//        for (int i = 0; i < files.length; i++) {
//            System.out.println(files[i].getAbsolutePath());
//        }

//        try (final FileInputStream in = new FileInputStream("java-core-03/src/main/java/ru/home/javaio/file1.txt")) {
//            int x;
//            while ((x = in.read()) != -1) {
//                System.out.print((char) x);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (final FileOutputStream out = new FileOutputStream("java-core-03/src/main/java/ru/home/javaio/file11.txt")) {
//            byte[] sentence = {78, 99, 22, 56, 12,};
//            out.write(sentence);
//            out.write("\nWhat's new man?".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // create a 5 Mb size file - very long to write by one byte
//        long time = System.currentTimeMillis();
//        try (OutputStream out = new FileOutputStream("java-core-03/src/main/java/ru/home/javaio/fileToWriteTest.txt")) {
//            for (int i = 0; i < 1024 * 1024 * 5; i++) {
//                out.write(65);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - time);

        // when we use BufferedOutputStream speed up approx. in 200 times
//        long timeBOS = System.currentTimeMillis();
//        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("java-core-03/src/main/java/ru/home/javaio/fileToWriteTest.txt"))) {
//            for (int i = 0; i < 1024 * 1024 * 5; i++) {
//                out.write(65);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - timeBOS);

        // we also can try to send the more large packages via to arrays for example
//        long timeArr = System.currentTimeMillis();
//        byte[] arr = new byte[1024];
//        Arrays.fill(arr, (byte) 65);
//        try (OutputStream out = new FileOutputStream("java-core-03/src/main/java/ru/home/javaio/fileToWriteTest.txt")) {
//            for (int i = 0; i < 1024 * 5; i++) {
//                out.write(65);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - timeArr);

        // correct partition read file by
//        byte[] data = new byte[64];
//        try (FileInputStream in = new FileInputStream("java-core-03/src/main/java/ru/home/javaio/fileToWriteTest.txt")) {
//            int len = 0;
//            while ((len = in.read(data)) > 0) {
//                System.out.println(new String(data, 0, len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String[] files = {
                "java-core-03/src/main/java/ru/home/javaio/directory/file2.txt",
                "java-core-03/src/main/java/ru/home/javaio/directory/file3.txt",
                "java-core-03/src/main/java/ru/home/javaio/directory/file4.txt",
                "java-core-03/src/main/java/ru/home/javaio/directory/file5.txt"
        };

        // parameters can be an array of files and then be requested array[i] where it needs
        concatenationFiles("java-core-03/src/main/java/ru/home/javaio/directory/fileToConcat.txt",
                "java-core-03/src/main/java/ru/home/javaio/directory/file2.txt",
                "java-core-03/src/main/java/ru/home/javaio/directory/file3.txt");

        concatFilesFromArr(files);
    }

    public static void concatenationFiles(String dest, String src1, String src2) {
        try (FileOutputStream out = new FileOutputStream(dest)) {
            int x;
            try (FileInputStream in = new FileInputStream(src1)) {
                while ((x = in.read()) != -1)
                    out.write(x);
            }
            try (FileInputStream in = new FileInputStream(src2)) {
                while ((x = in.read()) != -1)
                    out.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void concatFilesFromArr(String[] files) {
        try (FileOutputStream out = new FileOutputStream("java-core-03/src/main/java/ru/home/javaio/directory/fileToConcatFromArr.txt")) {
            int x;
            for (String f : files) {
                try (FileInputStream in = new FileInputStream(f)) {
                    while ((x = in.read()) != -1)
                        out.write(x);
                }
                out.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
