package ru.home.inheritance;

public class SimpleInheritance {
    public static void main(String[] args) {

        final A superOb = new A();
        final B subOb = new B();

        superOb.i = 10;
        superOb.j = 20;

        System.out.println("superOb content: ");
        superOb.showIj();
        System.out.println();

        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;
        System.out.println("subOb content: ");
        subOb.showIj();
        subOb.showK();

        System.out.println();
        System.out.println("subOb sum of i, j, k");
        subOb.sum();
    }

}

class A {
    int i, j;

    void showIj() {
        System.out.printf("i & j: %d %d\n", i, j);
    }
}

class B extends A {
    int k;

    void showK() {
        System.out.printf("k: %d\n", k);
    }

    void sum() {
        System.out.printf("i[%d] + j[%d] + k[%d] = ", i, j, k);
        System.out.print(i + j + k);
    }
}
