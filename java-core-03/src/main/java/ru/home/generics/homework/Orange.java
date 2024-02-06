package ru.home.generics.homework;

public class Orange extends Fruit {

    public Orange(String name, float weight) {
        super(name, weight);
        this.name = name;
        this.weight = 1.5f;
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
