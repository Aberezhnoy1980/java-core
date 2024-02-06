package ru.home.generics;

public class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb;
        iOb = new NonGen(88);

        iOb.showType();

        int v = (Integer) iOb.getObject();
        System.out.println("Value: " + v + "\n");

        NonGen strOb = new NonGen("Non generics test");

        strOb.showType();

        String str = (String) strOb.getObject();
        System.out.println("Value " + str);
    }
}
