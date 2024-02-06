package ru.home.classes;

public class VarArgs {
    static void vaTest(int... v) {
        System.out.print("Arguments count: " + v.length + " content: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String... args) {
        vaTest(10);
        vaTest(1, 2, 3);
        vaTest();
    }
}
