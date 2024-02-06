package ru.home.lesson5;

import javax.management.monitor.Monitor;

public class Classwork7MethodSyncApp {

    public static void main(String... args) throws InterruptedException {

        final Counter counter = new Counter();


        final Thread incThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                    counter.inc();
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.dec(); // sync via method
            }
        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println(counter.getValue());
    }
}
