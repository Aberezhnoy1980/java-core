package ru.home.inheritance.box;

import java.text.DecimalFormat;

public class DemoBoxWeight {
    public static void main(String[] args) {
        BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);

        System.out.printf("myBox1 volume is %s, weight is %.2f\n", new DecimalFormat("#.##").format(myBox1.volume()), myBox1.weight);
        System.out.printf("myBox2 volume is %.2f, weight is %.2f\n", myBox2.volume(), myBox2.weight);
    }
}
