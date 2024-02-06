package ru.home.functionInterface.supplier.training;

import java.util.function.Supplier;

public class First {
    // Реализуйте с помощью класса Supplier<String> который будет при каждом вызове get() возвращать слово полученное
    // из строки переданной в качестве параметра конструктору этого класса. Для упрощения задания выполните
    // разбиение строки по символу пробел.
    public static void main(String... args) {

        Supplier<String> stringSpliterator = new StringSpliterator("Hello java! How is going?");

        System.out.println(stringSpliterator.get());

    }

}

class StringSpliterator implements Supplier<String> {
    private String word;

    public StringSpliterator(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String get() {
        String[] words = word.split(" ");
        int index = (int) (Math.random() * words.length);
        return words[index];
    }
}
