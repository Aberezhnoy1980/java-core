package ru.home.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    public static void main(String[] args) {
        final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                read(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                read(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.readLock().lock();
                read(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.readLock().lock();
                read(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.writeLock().lock();
                write(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.writeLock().lock();
                write(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }).start();
    }


    private static void read(long millis) throws InterruptedException {
        System.out.println("READING-start-" + Thread.currentThread().getName());
        Thread.sleep(millis);
        System.out.println("READING-END-" + Thread.currentThread().getName());
    }

    private static void write(long millis) throws InterruptedException {
        System.out.println("WRITING-start-" + Thread.currentThread().getName());
        Thread.sleep(millis);
        System.out.println("WRITING-END-" + Thread.currentThread().getName());
    }
}
