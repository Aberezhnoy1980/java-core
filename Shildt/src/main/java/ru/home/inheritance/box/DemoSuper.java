package ru.home.inheritance.box;

public class DemoSuper {
    public static void main(String[] args) {
        final BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
        final BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);
        final BoxWeight myBox3 = new BoxWeight();
        final BoxWeight myCube = new BoxWeight(3, 2);
        final BoxWeight myClone = new BoxWeight(myBox1);

        System.out.printf("\tmyBox1 volume is %.2f and weight = %.2f\n", myBox1.volume(), myBox1.weight);
        System.out.printf("\tmyBox2 volume is %.2f and weight = %.2f\n", myBox2.volume(), myBox2.weight);
        System.out.printf("\tmyBox3 volume is %.2f and weight = %.2f\n", myBox3.volume(), myBox3.weight);
        System.out.printf("\tmyCube volume is %.2f and weight = %.2f\n", myCube.volume(), myCube.weight);
        System.out.printf("\tmyClone volume is %.2f and weight = %.2f\n", myClone.volume(), myClone.weight);
    }
}
