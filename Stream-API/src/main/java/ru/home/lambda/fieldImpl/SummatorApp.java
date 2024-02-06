package ru.home.lambda.fieldImpl;

public class SummatorApp {

    public static void main(String[] args) {

        SimpleClass simpleClass = new SimpleClass(new int[]{1, 2, 3});

        Summator summator = simpleClass.getSummatorInstance();

        System.out.println(summator.getSum());
    }
}
