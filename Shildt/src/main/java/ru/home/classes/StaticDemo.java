package ru.home.classes;

public class StaticDemo {
    static int a = 42;
    static int b = 99;

    static void callMe() {
        System.out.printf("a = %d", a);
    }
}

class StaticByName {
    public static void main(String[] args) {
        StaticDemo.callMe();
        System.out.printf("\nb = %d", StaticDemo.b);
    }
}
