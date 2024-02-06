package ru.home.functionInterface.comparable.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dao {

    Cat cat1 = new Cat("Umka", 12);
    Cat cat2= new Cat("Luska", 5);
    Cat cat3 = new Cat("Barsik", 8);
    Cat cat4 = new Cat("Timka", 4);
    Cat cat5 = new Cat("Kuzia", 2);

    private final List<Cat> cats1 = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));

    private static final List<Cat> cats2 = new ArrayList<>(Arrays.asList(
            new Cat("Umka", 12),
            new Cat("Luska", 5),
            new Cat("Barsik", 8),
            new Cat("Timka", 4),
            new Cat("Kuzia", 2)
    ));

    public List<Cat> getCatsFromLambda() {
        return cats1;
    }

    public static List<Cat> getCatsFromStatic() {
        return cats2;
    }

    public List<Cat> getCatsFromNonStatic() {
        return cats1;
    }
}
