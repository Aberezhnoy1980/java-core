package ru.home.functionInterface.binaryOperator.apply;

import java.util.function.BinaryOperator;

public class ApplyLambdaAndMethodReferenceApp {

    public static void main(String... arhs) {

        BinaryOperator<Integer> binaryOperator1 = (a, b) -> a + b;

        BinaryOperator<Integer> binaryOperator2 = ApplyLambdaAndMethodReferenceApp::sum;

        System.out.println(binaryOperator1.apply(1, 3));
        System.out.println(binaryOperator2.apply(1, 3));
    }

    private static Integer sum(Integer i1, Integer i2) {
        return i1 + i2;
    }
}
