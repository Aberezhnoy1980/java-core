package ru.home.testing.homework.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.home.testing.homework.ArrayAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayAnalyzerTest {

    public static Stream<Arguments> checkArrayArgs() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 1, 4, 4, 1, 1}, true));
        out.add(Arguments.arguments(new int[]{1, 4, 2, 1, 1, 1}, false));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("checkArrayArgs")
    public void testCheckArrayMethod(int[] arr, boolean result) {
        Assertions.assertEquals(result, ArrayAnalyzer.checkArray(arr));
    }

    public static Stream<Arguments> checkArrayForFalseArgs() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}));
        out.add(Arguments.arguments(new int[]{1, 4, 1, 4, 2, 1}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("checkArrayForFalseArgs")
    public void testCheckArrayForFalse(int[] arr) {
        Assertions.assertFalse(ArrayAnalyzer.checkArray(arr));
    }

    public static Stream<Arguments> modifyArrayArgs() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{0, 2, 3, 5, 4, 7, 9, 6, 7}, new int[]{7, 9, 6, 7}, false));
        out.add(Arguments.arguments(new int[]{0, 2, 4, 4, 4, 7, 4, 6, 7}, new int[]{6, 7}, false));
        out.add(Arguments.arguments(new int[]{0, 1, 2, 3, 5, 7, 8, 9, 112}, new int[]{}, true));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("modifyArrayArgs")
    public void testModifyArrayMethod(int[] sourceArr, int[] destArr, boolean isExceptionThrow) {
        Assertions.assertEquals(isExceptionThrow, ArrayAnalyzer.modifyArray(sourceArr) == destArr);
    }

    public static Stream<Arguments> arrModifyArrayArgs() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{3, 2, 3, 5, 4, 7, 9, 6, 7}, new int[]{7, 9, 6, 7}));
        out.add(Arguments.arguments(new int[]{2, 2, 4, 5, 4, 7, 9, 4, 7}, new int[]{7}));
        out.add(Arguments.arguments(new int[]{0, 0, 0, 0, 4, 4, 4, 4, 4}, new int[]{}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("arrModifyArrayArgs")
    public void testModifyArrayArr(int[] sourceArr, int[] destArr) {
        Assertions.assertArrayEquals(destArr, ArrayAnalyzer.modifyArray(sourceArr));
    }

    public static Stream<Arguments> exceptionModifyArrayArgs() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{3, 2, 3, 5, 4, 7, 9, 6, 7}, false));
        out.add(Arguments.arguments(new int[]{2, 2, 4, 5, 4, 7, 9, 4, 7}, true));
        out.add(Arguments.arguments(new int[]{0, 0, 0, 0, 4, 4, 4, 4, 4}, false));
        return out.stream();
    }

    @Test
    public void testModifyArrayException() {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayAnalyzer.modifyArray(new int[]{0, 2, 3, 5, 6, 7, 8}));
    }
}
