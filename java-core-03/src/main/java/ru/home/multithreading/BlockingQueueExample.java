package ru.home.multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {
    static class Producer {
        private ArrayBlockingQueue<String> queue;

        public Producer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        public void put(String s) {
            try {
                System.out.println("Producer add: " + s);
                queue.put(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer {
        private ArrayBlockingQueue<String> queue;

        public Consumer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        public String get() {
            try {
                String s = queue.take();
                System.out.println("Consumer get: " + s);
                return s;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        final ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

        new Thread(() -> {
            final Producer producer = new Producer(arrayBlockingQueue);
            for (int i = 0; i < 10; i++) {
                try {
                    producer.put(String.valueOf(i));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            final Consumer consumer = new Consumer(arrayBlockingQueue);
            for (int i = 0; i < 10; i++) {
                try {
                    consumer.get();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
