package ru.home.lesson5;

public class Classwork5JoinApp {

    public static void main(String[] args) {

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t3.start();
        try {
            t3.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}
