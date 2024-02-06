package ru.home.functionInterface.function.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class Forth {
    // Опишите такую реализацию BiFunction<String,String,String[]> которая вернет
    // в виде массива слова которые одновременно присутствуют и в первой строке
    // и во второй (слова разделены пробелами).
    // Например text1 = «Hello Java», text2 = «Hello Python» в результате должен быть массив вида [«Hello»].
    public static void main(String... args) {

        String text1 = "Hello java what is up";

        String text2 = "Hello Python how is going";

        BiFunction<String, String, String[]> repeatingWords = Forth::getDuplicate;

        System.out.println(Arrays.toString(repeatingWords.apply(text1, text2)));
    }

    private static String[] getDuplicate(String text1, String text2) {
        String[] text1Arr = text1.split(" ");
        String[] text2Arr = text2.split(" ");
//        String[] result = new String[text1Arr.length];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < text1Arr.length; i++) {
            String temp = text1Arr[i];
            for (String s : text2Arr) {
                if (Objects.equals(temp, s)) {
//                    result[i] = s;
                    result.add(temp);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
