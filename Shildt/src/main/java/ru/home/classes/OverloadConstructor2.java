package ru.home.classes;

public class OverloadConstructor2 {

    public static void main(String[] args) {
        final Box myBox1 = new Box(10, 20, 15);
        final Box myBox2 = new Box();
        final Box myCube = new Box(7);
        final Box myClone = new Box(myBox1);

        double vol;

        vol = myBox1.calcVolume();
        System.out.println("Volume myBox1 is " + vol);

        vol = myBox2.calcVolume();
        System.out.println("Volume myBox2 is " + vol);

        vol = myCube.calcVolume();
        System.out.println("Volume myCube is " + vol);

        vol = myClone.calcVolume();
        System.out.println("Volume nyClone is " + vol);
    }
}
