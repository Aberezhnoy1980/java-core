package ru.home.generics.homework;

public abstract class Fruit {
    String name;
    float weight;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public abstract String infoTicket();
}
