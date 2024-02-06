package ru.home.classes;

public class AccessTest {
    public static void main(String... args) {
        final AccTest ob = new AccTest();

        ob.a = 10;
        ob.b = 20;

        ob.setC(100);
        System.out.printf("a = %d, b = %d and c = %d", ob.a, ob.b, ob.getC());
    }
}

class AccTest {
    int a;
    public int b;
    private int c;

    void setC(int i) {
        c = i;
    }

    int getC() {
        return c;
    }
}
