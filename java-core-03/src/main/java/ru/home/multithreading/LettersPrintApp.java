package ru.home.multithreading;

public class LettersPrintApp {
	private static final Object monitor = new Object();
	private static char currentLetter = 'A';

	public static void main(String[] args) {
		new Thread(() -> {
			printA();
		}).start();
		new Thread (() -> {
			printB();
		}).start();
		new Thread(LettersPrintApp::printC).start();
		
	}

	private static void printA() {
		synchronized(monitor) {
			
			try {
				for (int i = 0; i < 5; i++) {
					while (currentLetter != 'A') {
						monitor.wait();
					}
					System.out.print('A');
					currentLetter = 'B';
					monitor.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printB() {
		synchronized(monitor) {
			try {
				for (int i = 0; i < 5; i++) {
					while (currentLetter != 'B') {
						monitor.wait();
					}
					System.out.print('B');
					currentLetter = 'C';
					monitor.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printC() {
		synchronized(monitor) {
			try {
				for (int i = 0; i < 5; i++) {
					while (currentLetter != 'C') {
						monitor.wait();
					}
					System.out.print('C');
					currentLetter = 'A';
					monitor.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
