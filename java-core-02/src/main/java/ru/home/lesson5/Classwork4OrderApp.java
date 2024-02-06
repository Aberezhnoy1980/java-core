package ru.home.lesson5;

import java.rmi.activation.ActivationGroup_Stub;

public class Classwork4OrderApp {

    public static void main(String... args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });
        t1.start();
        t2.start();

    }
}
