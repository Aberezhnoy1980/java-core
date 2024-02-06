package ru.home.lesson5;

public class ClassworkApp {
    public static void main(String[] args) throws InterruptedException {

        final MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}