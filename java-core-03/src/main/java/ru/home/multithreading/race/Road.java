package ru.home.multithreading.race;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Track " + length + " m";
    }
    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " started stage: " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);
            System.out.println(car.getName() + " finished stage: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if (isTheLastChallenge) System.out.println(car.getName() + " WIN!!!");
        }
    }
}
