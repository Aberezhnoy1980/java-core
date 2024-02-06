package ru.home.lambda.staticImpl;

public class StaticImplApp {

    public static void main(String... args) {

        SimpleClassWithStaticFields.setArr(new int[]{3, 4, 5});

        System.out.println(SimpleClassWithStaticFields.getSummator().getSum());
    }
}
