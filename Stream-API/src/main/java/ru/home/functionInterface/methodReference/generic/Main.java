package ru.home.functionInterface.methodReference.generic;

public class Main {

    public static void main(String... args) {

        NumberGenerator numberGenerator = new NumberGenerator();

        Modifier<Integer> integerModifier = numberGenerator::add;

        Modifier<Double> doubleModifier = numberGenerator::add;

        Modifier<String> stringModifier = numberGenerator::add;

        System.out.println(integerModifier.change(10));
        System.out.println(doubleModifier.change(100.0));
        System.out.println(stringModifier.change("text"));

        // reversed

        Gen gen = new Gen();

        IntElementGenerator intElementGenerator = gen::nextElement; // gen::<Integer>nextElement

        System.out.println(intElementGenerator.next(12));
    }
}
