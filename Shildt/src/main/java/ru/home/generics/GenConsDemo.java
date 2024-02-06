package ru.home.generics;

public class GenConsDemo {
    public static void main(String[] args) {
        final GenCons genCons1 = new GenCons(100);
        final GenCons genCons2 = new GenCons(123.5f);

        genCons1.showVal();
        genCons2.showVal();
    }

    private static class GenCons {
        private double val;

        <T extends Number> GenCons(T arg) {
            val = arg.doubleValue();
        }

        void showVal() {
            System.out.println("val: " + val);
        }
    }
}
