package ru.home.generics.homework;

public class FruitApp {

    public static void main(String... args) {

        final Apple apple = new Apple("Apple", 1.0f);
        final BoxWithFruits<Apple> appleBox = new BoxWithFruits<>("Apple");
        appleBox.putFruitsInTheBox(apple, 15);
        System.out.println(apple + "\n" + appleBox + "\n");

        final Orange orange = new Orange("Orange", 1.5f);
        final BoxWithFruits<Orange> orangeBox = new BoxWithFruits<>("Orange");
        orangeBox.putFruitsInTheBox(orange, 10);
        System.out.println(orange + "\n" + orangeBox + "\n");

        final BoxWithFruits<Apple> appleBoxForShift = new BoxWithFruits<>("Sprinkled apples");
        appleBox.shiftFruits(appleBoxForShift);
        System.out.println(appleBox + "\n" + appleBoxForShift);

        System.out.println(appleBox.compare(appleBoxForShift));
        System.out.println(orangeBox.compare(appleBoxForShift));

    }
}
