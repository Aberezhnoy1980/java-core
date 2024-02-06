package ru.home.generics;

public class GenDemo {

    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);

        iOb.showType();

        int v = iOb.getOb();
        System.out.println("Value: " + v + "\n");

        Gen<String> strOb = new Gen<>("Generics test");
        strOb.showType();
        String str = strOb.getOb();
        System.out.println("Value: " + str);
    }
}
