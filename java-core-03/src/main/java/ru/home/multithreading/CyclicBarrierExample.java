package ru.home.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int THREADS_COUNT = 5;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " getting ready to sleep");
                    Thread.sleep(2000 +  (int) (5000 * Math.random()));
                    System.out.println(Thread.currentThread().getName() + " is ready to sleep");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " start to sleep");
                    Thread.sleep(2000 +  (int) (5000 * Math.random()));
                    System.out.println(Thread.currentThread().getName() + " finish sleeping");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " continued to do nothing))");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
