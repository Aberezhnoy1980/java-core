package ru.home.multithreading.race;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean isWinner;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;

    private final CountDownLatch countDownLatchForStart;
    private final CountDownLatch countDownLatchForFinish;
    private final CyclicBarrier cyclicBarrier;

    private Lock winCup;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatchForStart, CountDownLatch countDownLatchForFinish, CyclicBarrier cyclicBarrier, Lock winCup) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Participant# " + CARS_COUNT;
        this.countDownLatchForStart = countDownLatchForStart;
        this.countDownLatchForFinish = countDownLatchForFinish;
        this.cyclicBarrier = cyclicBarrier;
        this.winCup = winCup;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + "preparing");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " is ready");
            countDownLatchForStart.countDown();
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if (i == race.getStages().size() - 1)
                if (!isWinner) {
                    race.getStages().get(i).setTheLastChallenge(true);
                    isWinner = true;
                }
        }
//        if(winCup.tryLock()) System.out.println(this.name + " WIN!!");
        countDownLatchForFinish.countDown();
    }

    private static synchronized void winner(Car car) {
        if (!isWinner) {
            System.out.println(car.name + " WIN!!!");
            isWinner = true;
        }
    }
}
