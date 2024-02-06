package ru.home.classes;

public class PassArray {
    static void vaTest(int[] v) {
        System.out.printf("Arguments count: %d content: ", v.length);
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] n1 = {10};
        int[] n2 = {1, 2, 3};
        int[] n3 = {};

        vaTest(n1);
        vaTest(n2);
        vaTest(n3);
    }
}
