package ru.home.multithreading.race;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Stage {
    public boolean getIsTheLastChallenge() {
        return isTheLastChallenge;
    }

    public void setTheLastChallenge(boolean theLastChallenge) {
        isTheLastChallenge = theLastChallenge;
    }

    static boolean isTheLastChallenge;
    final Lock winCup = new ReentrantLock();

    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car car);
}

