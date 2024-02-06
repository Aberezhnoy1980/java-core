package ru.home.functionInterface.binaryOperator.primitive;

import java.util.function.IntBinaryOperator;

public class PrimitiveApp {
    // IntBinaryOperator - использует в качестве параметров тип int и возвращает значение типа int.
    //LongBinaryOperator - использует в качестве параметра тип long и возвращает значение типа long.
    //DoubleBinaryOperator- использует в качестве параметра тип double и возвращает значение типа double.
    public static void main(String... args) {

        IntBinaryOperator intBinaryOperator = PrimitiveApp::gcd;
        System.out.println(intBinaryOperator.applyAsInt(7, 11));

    }

    // Наибольший общий делитель по алгоритму Евклида
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        int r = a % b;
        // While
        for (; r != 0; ) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
}
