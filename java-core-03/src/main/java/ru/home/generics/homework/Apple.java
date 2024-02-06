package ru.home.generics.homework;

public class Apple extends Fruit {

    public Apple(String name, float weight) {
        super(name, weight);
        this.name = name;
        this.weight = 1.0f;
    }

    @Override
    public String infoTicket() {
        return "My name " + name + " and my weight is " + weight;
    }

    @Override
    public String toString() {
        return infoTicket();
    }
}
