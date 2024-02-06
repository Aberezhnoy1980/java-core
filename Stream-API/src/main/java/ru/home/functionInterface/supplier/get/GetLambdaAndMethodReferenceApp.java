package ru.home.functionInterface.supplier.get;

import java.util.function.Supplier;

public class GetLambdaAndMethodReferenceApp {
    public static void main(String... args) {

        Supplier<Integer> sup1 = () -> (int) (Math.random() * 10);

        Supplier<Integer> sup2 = GetLambdaAndMethodReferenceApp::getRandomNumber;

        System.out.println(sup1.get());
        System.out.println(sup2.get());
    }

    private static Integer getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
