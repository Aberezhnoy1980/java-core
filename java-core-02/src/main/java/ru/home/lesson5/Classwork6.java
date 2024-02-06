package ru.home.lesson5;

public class Classwork6 {

    private static int value = 0;
    
    public static void main(String[] args) throws InterruptedException {

        // 0 + 100 - 100? NO!
        final Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                value++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        final Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                value--;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(value);
    }
}
