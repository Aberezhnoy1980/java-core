package ru.home.classes;

public class OverloadConstructor {
    // Create parallelepiped using different constructors
    public static void main(String[] args) {
        Box box1 = new Box(10, 20, 15);
        final Box box2 = new Box();
        final Box myCube = new Box(7);

        double volume;

        volume = box1.calcVolume();
        System.out.println("Volume box1 is " + volume);

        volume = box2.calcVolume();
        System.out.println("Volume box2 is " + volume);

        volume = myCube.calcVolume();
        System.out.println("Volume myCube is " + volume);
    }
}
