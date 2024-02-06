package ru.home.lesson5;

public class Classwork2LambdaApp {

    public static void main(String... args) {

        // public class Classwork2Lambda$1 implements Runnable {
        //     @Override
        //     public void run() {
        //         for (int = i = 1; i < 10; I++) {
        //             System.out.println(i);
        //         }
        //     }
        // }
        // Thread thread = new Thread(new Classwork2Lambda());

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();

        System.out.println(Thread.currentThread().getName());
    }
}
