package ru.home.testing.homework.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.home.testing.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CalcTest {
    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
        System.out.println("init");
    }

    @AfterEach
    public void shutdown() {
        System.out.println("shutdown");
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

//    @Test
//    public void testAdd1() {
//        Assertions.assertEquals(4, calculator.add(2, 2));
//        Assertions.assertEquals(6, calculator.add(13, 3));
//        Assertions.assertEquals(8, calculator.add(4, 14));
//    }

    @CsvSource({
            "5, 5, 10",
            "1, 1, 2",
            "6, 7, 13",
            "10, 20, 30",
            "0, 10, 10"
    })
    @ParameterizedTest
    public void addTest(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    @Disabled
    public void testSum(int[] arr) {
        Assertions.assertEquals(15, calculator.sumThroughFori(arr), "хуйня какаята");
    }

    public static Stream<Arguments> generateArray() {
        List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            out.add(Arguments.arguments(1, 2, 3, 4, 5));
        }
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("generateArray")
    @Disabled
    public void testSum1(int[] arr) {
        Assertions.assertEquals(15, calculator.sum(arr));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(10, calculator.sub(20, 10));
    }

    @Test
    public void testMul() {
        Assertions.assertEquals(10, calculator.mul(5, 2));
    }

    @Test
    public void testDiv() {
        Assertions.assertEquals(10, calculator.div(100, 10));
    }

}
