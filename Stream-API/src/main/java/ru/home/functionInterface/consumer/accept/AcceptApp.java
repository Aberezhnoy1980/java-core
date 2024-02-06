package ru.home.functionInterface.consumer.accept;

import java.util.function.Consumer;

public class AcceptApp {
    // void accept(T t)
    // Выполняет операцию над объектом, ссылка на который, передается в качестве параметра.
    public static void main(String[] args) {

        Consumer<String> strCons1 = new HashCodePrinter<>();

        Consumer<String> strCons2 = a -> simplePrinter(a);

        Consumer<String> strCons3 = AcceptApp::simplePrinter;

        strCons1.accept("Hello");
        strCons2.accept("Hello");
        strCons3.accept("Hello");
    }

    public static <T> void simplePrinter(T operand) {
        System.out.println("{" + operand + "}");
    }
}

class HashCodePrinter<T> implements Consumer<T> {
    @Override
    public void accept(T t) {
        System.out.println(t.hashCode());
    }
}