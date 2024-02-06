package ru.home.inheritance.box;

public class BoxWeight extends Box {
    double weight;

    BoxWeight(double h, double w, double d, double m) {
        super(h, w, d);
        weight = m;
    }

    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight() {
        super();
        weight = -1;
    }

    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}
