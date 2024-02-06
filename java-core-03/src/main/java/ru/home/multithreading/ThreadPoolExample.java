package ru.home.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// how to create overused threads
public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor(); // one work thread
        final ExecutorService cachedPoolExecutorService = Executors.newCachedThreadPool((Runnable runnable) -> {
            System.out.println("New thread created");
            return new Thread(runnable);
        }); // creates new threads as needed with no limit

        final ExecutorService fixedPooExecutorService = Executors.newFixedThreadPool(4, (Runnable runnable) -> {
            System.out.println("Thread created");
            return new Thread(runnable);
        }); // limited list of threads
//        for (int i = 0; i < 5; i++) {
//            fixedPooExecutorService.execute(() -> {
//                System.out.println("START TASK" + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("TASK END" + Thread.currentThread().getName());
//            });
//        }
//        fixedPooExecutorService.shutdown();
//        System.out.println("END");

        // try fixedPool to find out how threads will be created through to ThreadFactory
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        Thread.sleep(2000);
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        fixedPooExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));
//        fixedPooExecutorService.shutdown();

        Future<String> future = fixedPooExecutorService.submit(() -> {
            Thread.sleep(2000);
            return "Java from " + Thread.currentThread().getName();
        });

        try {
            String s = future.get();
            System.out.println(s + " received in " + Thread.currentThread().getName());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        fixedPooExecutorService.shutdown();
    }
}
