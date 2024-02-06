package ru.home.javaio;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
    private String name;
    private int age;
    private String color;
    private Toy toy;

    public Cat(String name, int age, String color) {
        super(4);
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(){
        this.color = color;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    @Override
    public String toString() {
        return String.format("name: %s, age: %d, color: %s", name, age, color);
    }
}
