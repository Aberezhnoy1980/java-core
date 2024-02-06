package ru.home.multithreading.race;

import java.io.CharArrayReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ATTENTION >>> Preparing!");

        final CountDownLatch countDownLatchForStart = new CountDownLatch(CARS_COUNT);
        final CountDownLatch countDownLatchForFinish = new CountDownLatch(CARS_COUNT);
        final Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        final Lock winCup = new ReentrantLock();

        final Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        final Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatchForStart, countDownLatchForFinish, cyclicBarrier, winCup);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            countDownLatchForStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ATTENTION >>> The race has started!!!");
        try {
            countDownLatchForFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ATTENTION >>> The race is over!!!");
    }
}
