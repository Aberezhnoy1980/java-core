package ru.home.reflection;

public class Cat {
    private int privateA;
    int defaultB;
    protected int protectedC;
    public int publicD;

    public Cat() {
    }

    public Cat(int privateA, int publicD) {
        this.privateA = privateA;
        this.publicD = publicD;
    }

    private void privateVoidMethod() {
        System.out.println("private void method");
    }

    public void publicVoidMethod() {
        System.out.println("public void method");
    }

    void defaultMethod() {
        System.out.println("default void method");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
