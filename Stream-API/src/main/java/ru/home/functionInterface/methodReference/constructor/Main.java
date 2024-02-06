package ru.home.functionInterface.methodReference.constructor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Generator gen1 = ArrayList::new;

        Object list = gen1.createNewObject();

        System.out.println(list.getClass());

        GeneratorForArray gen2 = int[]::new;

        Object array = gen2.createNewObject(10);

        System.out.println(array.getClass());
    }
}
