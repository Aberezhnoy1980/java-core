package ru.home.multithreading.race;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore semaphore;
    public Tunnel(Semaphore semaphore) {
        this.length = 80;
        this.description = "Tunnel " + length + " m";
        this.semaphore = semaphore;
    }

    @Override
    public void go(Car car) {
        try {
            try {
                semaphore.acquire();
                System.out.println(car.getName() + " preparing for the stage(waiting): " + description);
                System.out.println(car.getName() + " started stage: " + description);
                Thread.sleep(length / car.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(car.getName() + " finished stage: " + description);
                if (isTheLastChallenge) System.out.println(car.getName() + " WIN!!!");
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
