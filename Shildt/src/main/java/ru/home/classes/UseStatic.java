package ru.home.classes;

public class UseStatic {
    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.printf("x = %d\n", x);
        System.out.printf("a = %d\n", a);
        System.out.printf("b = %d\n", b);
    }

    static {
        System.out.println("Static block initialized");
        b = a * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }
}
