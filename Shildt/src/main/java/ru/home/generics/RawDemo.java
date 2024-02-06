package ru.home.generics;

public class RawDemo {
    static class Gen<T> {
        T ob;

        Gen(T o) {
            ob = o;
        }

        T getOb() {
            return ob;
        }
    }

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);

        Gen<String> strOb = new Gen<>("Generics test");

        Gen raw = new Gen(new Double(98.6)); // Base (raw) type

        double d = (Double) raw.getOb();
        System.out.println("Value: " + d);

        // Errors!
//        int i = (Integer) raw.getOb();
//        strOb = raw; => String str = strOb.getOb();
        // raw = iOb; => d = (Double) raw.getOb();
    }
}
