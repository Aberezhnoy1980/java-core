package ru.home.functionInterface.optional.common;

public class Cat {
    private String name;
    private String color;

    public Cat(String name, String color) {
        super();
        this.name = name;
        this.color = color;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Cat name %s, color %s\n", name, color);
    }
}
