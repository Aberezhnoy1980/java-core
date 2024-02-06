package ru.home.functionInterface.function.apply;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ApplyWithMethodProApp {

    public static void main(String[] args) {

        List<String> list = List.of("Java", "Python", "Fortran", "C");

        Function<String, Integer> funcStrToInt = String::length;

        List<Integer> modifiedList = applyAndCreate(funcStrToInt, list);

        System.out.println(modifiedList);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Function<Integer, BigInteger> funcFactorial = n -> {
            BigInteger factorial = new BigInteger("1");
            for (int i = 1; i <= n; i++) {
                factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
            }
            return factorial;
        };

        List<BigInteger> resList = applyAndCreate(funcFactorial, numbers);

        System.out.println(resList);

    }
    public static <R, T> List<R> applyAndCreate(Function<T, R> fun, List<T> list) {
        List<R> resultList = new ArrayList<>();
        for (T t : list) {
            resultList.add(fun.apply(t));
        }
        return resultList;
    }
}
