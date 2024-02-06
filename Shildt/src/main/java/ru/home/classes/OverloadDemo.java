package ru.home.classes;

// Method overload demonstration
public class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

    // overloaded method showing one integer parameter
    void test(int a) {
        System.out.println("a: " + a);
    }

    // overloaded method showing two integer parameter
    void test(int a, int b) {
        System.out.println("a & b: " + a + " " + b);
    }

    // overloaded method that checking double type parameter.
    double test(double a) {
        System.out.println("double a: " + a);
        return a * a;
    }

    // Internal cast on invoke
    void test(double c, double d, double e) {
        System.out.println("Internal cast on test (double) c & d & e invoke : " + c + " " + d + " " + e);
    }
}

class Overload {
    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
        double result;
        int i = 88;
        int f = 99;
        int g = 77;

        ob.test();
        ob.test(10);
        ob.test(10, 20);
        result = ob.test(123.25);
        System.out.println("Result of ob.test(123.25) method invoke: " + result);

        ob.test(i, f, g);
        ob.test(123.2, 321.1, 0.03);
    }
}
