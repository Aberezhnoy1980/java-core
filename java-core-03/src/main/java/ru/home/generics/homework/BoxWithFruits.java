package ru.home.generics.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxWithFruits<T extends Fruit> {

    private final List<T> fruits;
    private final String type;

    public BoxWithFruits(String type) {
        this.fruits = new ArrayList<>();
        this.type = type;
    }

    public float calcWeight() {
        if (fruits.isEmpty()) return 0.0f;
        return fruits.size() * fruits.get(0).getWeight();
    }

    public void putFruitsInTheBox(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            this.fruits.add(fruit);
        }
    }

    public boolean compare(BoxWithFruits<?> another) {
        return Math.abs(this.calcWeight() - another.calcWeight()) < 0.0001;
    }

    public void shiftFruits(BoxWithFruits<T> another) {
        if (this == another || !this.getClass().isInstance(another)) return;
        for (T f : this.fruits) {
            another.fruits.add(f);
        }
        this.fruits.clear();
    }

    @Override
    public String toString() {
        return "Box with " + type + "s" + " contains " + fruits.size() + " " + type + " and has a weight: " + calcWeight();
    }
}
