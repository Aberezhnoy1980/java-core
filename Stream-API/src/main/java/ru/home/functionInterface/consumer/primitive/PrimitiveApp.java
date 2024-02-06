package ru.home.functionInterface.consumer.primitive;

import java.util.function.IntConsumer;

public class PrimitiveApp {
    // IntConsumer - использует в качестве параметра тип int
    //LongConsumer - использует в качестве параметра тип long
    //DoubleConsumer - Использует в качестве параметра тип double
    public static void main(String[] args) {

        IntConsumer intCons = i -> {
            if (i % 2 == 0) System.out.println(i + " is even number");
            else System.out.println(i + " is odd number");
        };

        intCons.accept(16);
    }
}
