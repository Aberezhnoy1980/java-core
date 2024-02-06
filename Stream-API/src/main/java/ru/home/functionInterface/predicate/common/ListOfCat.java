package ru.home.functionInterface.predicate.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfCat {

    private final Cat cat1 = new Cat("Umka", 12);
    private final Cat cat2 = new Cat("Luska", 5);
    private final Cat cat3 = new Cat("Barsik", 8);
    private final Cat cat4 = new Cat("Timka", 4);
    private final Cat cat5 = new Cat("Kuzia", 2);

    private final List<Cat> cats = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));

    public static final List<Cat> cats1 = new ArrayList<>(Arrays.asList(
            new Cat("Umka", 12),
            new Cat("Luska", 5),
            new Cat("Barsik", 8),
            new Cat("Timka", 4),
            new Cat("Kuzia", 2)
    ));

    public List<Cat> getCatsFromLambda() {
        return cats;
    }

    public static List<Cat> getCatsFromStatic() {
        return cats1;
    }

    public List<Cat> getCatsFromNonStatic() {
        return cats;
    }
}
