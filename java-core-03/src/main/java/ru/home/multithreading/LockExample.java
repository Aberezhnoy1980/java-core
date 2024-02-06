package ru.home.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            System.err.println("BEFORE-LOCK-" + Thread.currentThread().getName());
            try {
                lock.lock();
                System.err.println("GET-LOCK-" + Thread.currentThread().getName());
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.err.println("END-" + Thread.currentThread().getName());
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.err.println("BEFORE-LOCK-" + Thread.currentThread().getName());
            try {
                if (lock.tryLock(4, TimeUnit.SECONDS)) {
                    try {
                        System.err.println("GET-LOCK-" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        lock.unlock();
                        System.err.println("END-" + Thread.currentThread().getName());
                    }
                } else {
                    System.err.println("I don't give a fuck");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
