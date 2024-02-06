package ru.home.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SimpleSemaphoreExample {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(4);

        final Runnable limitedCall = new Runnable() {

            public void run() {
                int time = 1 + (int) (Math.random() * 4.0);
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " start to execute very long action " + time + "sec.");
                    Thread.sleep(time * 1000L);
                    System.out.println(Thread.currentThread().getName() + " finished the task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
