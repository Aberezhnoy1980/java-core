package ru.home.classes;

public class RetOb {
    public static void main(String[] args) {
        final Test2 ob1 = new Test2(2);
        Test2 ob2;

        ob2 = ob1.incrByTen();
        System.out.println("ob1.a: " + ob1.a);
        System.out.println("ob2.a: " + ob2.a);

        ob2 = ob2.incrByTen();
        System.out.println("ob2.a after second increment: " + ob2.a);
    }
}

class Test2 {
    int a;

    Test2(int i) {
        a = i;
    }

    Test2 incrByTen() {
        Test2 temp = new Test2(a + 10);
        return temp;
    }
}
