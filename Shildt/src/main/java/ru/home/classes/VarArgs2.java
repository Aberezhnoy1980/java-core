package ru.home.classes;

public class VarArgs2 {
    static void vaTest(String msg, int... v) {
        System.out.print(msg + v.length + " content: ");

        for(int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        vaTest("One parameter of variable length ", 10);
        vaTest("Three parameters of variable length ", 1, 2, 3);
        vaTest("Zero parameters of variable length ");
    }
}
