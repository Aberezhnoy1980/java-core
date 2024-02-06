package ru.home.javaio;

import java.io.Serializable;

public class Toy implements Serializable {
    private String color;

    public Toy(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "the toy color is: " + color;
    }

}
