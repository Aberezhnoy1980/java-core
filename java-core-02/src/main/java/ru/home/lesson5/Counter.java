package ru.home.lesson5;

public class Counter {
    private int x;

    public synchronized void inc() {
        x++;
    }

    public synchronized void dec() {
        x--;
    }

    public int getValue() {
        return x;
    }
}
