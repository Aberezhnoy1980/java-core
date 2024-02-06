package ru.home.lesson5;

import javax.management.monitor.Monitor;

public class DoubleCounter {
    private int x;
    private int y;

    private final Monitor monitorX;
    private final Monitor monitorY;

    public DoubleCounter(Monitor monitorX, Monitor monitorY) {
        this.monitorX = monitorX;
        this.monitorY = monitorY;
    }

    public void incX() {
        synchronized (monitorX) {
            x++;
        }
    }

    public void incY() {
        synchronized (monitorY) {
            y++;
        }
    }
}
