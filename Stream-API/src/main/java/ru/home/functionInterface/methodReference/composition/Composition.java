package ru.home.functionInterface.methodReference.composition;

import java.util.Arrays;
import java.util.function.Function;

public class Composition {

    public static void main(String... args) {

        Function<Integer, String[]> fun = functionComposition(Composition::intToString, Composition::strToArray);

        String[] res = fun.apply(5);

        System.out.println(Arrays.toString(res));

    }

    public static <F, S, R> Function<F, R> functionComposition(Function<F, S> f1, Function<S, R> f2) {
        class LocalComposition {
            public R comp(F t) {
                S temp = f1.apply(t);
                return f2.apply(temp);
            }
        }
        LocalComposition localComposition = new LocalComposition();
        return localComposition::comp;
    }

    public static String intToString(Integer count) {
        return "Hello " + count;
    }

    public static String[] strToArray(String text) {
        String[] r = text.split(" ");
        String[] result = new String[Integer.parseInt(r[1])];
        for (int i = 0; i < result.length; i++) {
            result[i] = r[0];
        }
        return result;
    }
}
