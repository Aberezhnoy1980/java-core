package ru.home.inheritance.box;

public class Box {

    private double height;
    private double width;
    private double depth;

    Box(Box ob) {
        height = ob.height;
        width = ob.width;
        depth = ob.depth;
    }

    Box(double h, double w, double d) {
        height = h;
        width = w;
        depth = d;
    }

    Box() {
        height = -1;
        width = -1;
        depth = -1;
    }

    Box(double len) {
        height = width = depth = len;
    }

    double volume() {
        return height * width * depth;
    }
}
