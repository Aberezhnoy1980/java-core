package ru.home.annotation;

public class DemoClass {
    @MyAnno
    public static void method1() {
        System.out.println(1);
    }
    @MyAnno
    public static void method2() {
        System.out.println(2);
    }
    @MyAnno(priority = 2)
    public static void method3() {
        System.out.println(3);
    }
}
