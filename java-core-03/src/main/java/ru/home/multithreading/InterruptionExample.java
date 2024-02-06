package ru.home.multithreading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            boolean isInterruptedByException = false;
            for (; ; ) {
                if (Thread.currentThread().isInterrupted() || isInterruptedByException) {
                    break;
                }
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
                    isInterruptedByException = true;
				}
                System.out.println(1);
            }
        });
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }

    //	Thread t = new Thread(new Runnable() {
    //		@Override
    //		public void run () {
    //			while (true) {
    //				if (Thread.currentThread().isInterrupted()) {
    //					break;
    //				}
    //				System.out.println(1);
    //			}
    //
    //		}
    //	});
    //	t.start();
    //	Thread.sleep(500);
    //	t.interrupt();

//		Thread t = new Thread(() -> {
//			boolean interruptedByException = false;
//			while (!Thread.currentThread().isInterrupted() && !interruptedByException) {
//				System.out.println(1);
//				try {
//					Thread.sleep(2500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(2);
//			}
//		});
//		t.start();
//		Thread.sleep(500);
//		t.interrupt();
//	}
}
