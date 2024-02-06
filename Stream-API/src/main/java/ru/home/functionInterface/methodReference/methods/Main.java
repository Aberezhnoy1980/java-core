package ru.home.functionInterface.methodReference.methods;

public class Main {
    public static void main(String... args) {

        SimpleGen simpleGen = new SimpleGen(5);

        Generator gen1 = simpleGen::getNumber; // reference on non-static object method

        int temp = gen1.getNextElement();

        System.out.println(temp);

        Generator gen2 = SimpleGen::getRandomNumber; // reference on static (class responsibility) method

        System.out.println(gen2.getNextElement());

        GeneratorAnyObject gen3 = IntGenerator::next; // reference on non-static any object method

        IntGenerator intGenerator = new IntGenerator();

        System.out.println(gen3.getNextElement(intGenerator));
    }
}
