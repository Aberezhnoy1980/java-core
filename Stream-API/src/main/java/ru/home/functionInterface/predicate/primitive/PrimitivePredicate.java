package ru.home.functionInterface.predicate.primitive;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class PrimitivePredicate {
    // IntPredicate (LongPredicate, DoublePredicate)
    public static void main(String... args) {

        IntPredicate intPred = a -> a % 2 == 0;

        System.out.println(intPred.test(1));

        int[] array = new int[]{-4, 1, 6, -3, 0, 1, 7};

        int even = countElement(array, e -> e % 2 == 0);

        int odd = countElement(array, e -> e % 3 != 0);

        System.out.println(Arrays.toString(array));

        System.out.println("Even = " + even);

        System.out.println("Odd = " + odd);
    }

    public static int countElement(int[] array, IntPredicate intPredicate) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (intPredicate.test(array[i])) {
                count += 1;
            }
        }
        return count;
    }
}
