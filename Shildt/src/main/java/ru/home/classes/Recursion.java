package ru.home.classes;

class Factorial {
    int fact(int n) {
        int result;

        if (n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }
}
public class Recursion {
    public static void main(String[] args) {
        final Factorial f = new Factorial();

        System.out.println("Factorial 3 is: " + f.fact(3));
        System.out.println("Factorial 4 is: " + f.fact(4));
        System.out.println("Factorial 5 is: " + f.fact(5));
        System.out.println("Factorial 1 is: " + f.fact(1));
    }
}
