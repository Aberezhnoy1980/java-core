package ru.home.classes;

public class Outer {
    int outer_x = 100;
    int outer_y = 200;

    void test() {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            class InnerInFor{
                void show(){
                    System.out.println("Inner class in cycle for [" + finalI + "] outer_y = " + outer_y);
                }
            }
        final InnerInFor innerInFor = new InnerInFor();
        innerInFor.show();
        }
        final Inner inner = new Inner();
        inner.display();
    }
    class Inner {
        void display() {
            System.out.printf("Output: outer_x = %d", outer_x);
        }
    }
}

class InnerClassDemo {
    public static void main(String[] args) {
        final Outer outer = new Outer();
        outer.test();
    }
}