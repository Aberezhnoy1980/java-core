package ru.home.generics;

public class BoundsDemo {
    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(inums);
        double v = iob.average();
        System.out.println("Average iob is " + v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dnums);
        double w = dob.average();
        System.out.println("Average dob is " + w);

        Float[] fnums = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Stats<Float> fob = new Stats<>(fnums);
        double x = fob.average();
        System.out.println("Average fob is " + x);

        System.out.print("Average values for iob and dob is ");
        if (iob.sameAvs(dob)) System.out.println("equal");
        else System.out.println("not equal");

        System.out.print("Average values for iob and fob is ");
        if(iob.sameAvs(fob)) System.out.println("equal");
        else System.out.println("not equal");
    }
}
