package ru.home.classes;

public class VarArgs3 {
    static void vaTest(int... v) {
        System.out.print("Arguments count: " + v.length + " content: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(String msg, int... v) {
        System.out.print(msg + v.length + " content: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(Boolean... v) {
        System.out.print("Arguments count: " + v.length + " content: ");
        for(Boolean x : v)
            System.out.print(x + " ");
    }

    public static void main(String[] args) {
        vaTest(1, 2, 3);
        vaTest("Checking: ", 10, 20);
        vaTest(true, false, true);
    }
}
