package ru.home.functionInterface.unaryOperator.primitive;

import java.util.function.IntUnaryOperator;

public class PrimitiveApp {
    // IntUnaryOperator - использует в качестве параметра тип int и возвращает значение типа int.
    //LongUnaryOperator - использует в качестве параметра тип long и возвращает значение типа long.
    //DoubleUnaryOperator - использует в качестве параметра тип double и возвращает значение типа double.
    public static void main(String... args) {

        IntUnaryOperator factorial = PrimitiveApp::getFactorial;

        System.out.println(factorial.applyAsInt(3));

        // primitive + andThen
        IntUnaryOperator unOp1 = i -> i + 1;
        IntUnaryOperator unOp2 = i -> i * 2;
        IntUnaryOperator result = unOp1.andThen(unOp2);

        System.out.println(result.applyAsInt(3));
    }

    private static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
