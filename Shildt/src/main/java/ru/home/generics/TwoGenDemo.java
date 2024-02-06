package ru.home.generics;

public class TwoGenDemo {
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generics");

        tgObj.showType();

        int v = tgObj.getOb1();
        System.out.println("Value " + v);

        String str = tgObj.getOb2();
        System.out.println("Value " + str);
    }
}
