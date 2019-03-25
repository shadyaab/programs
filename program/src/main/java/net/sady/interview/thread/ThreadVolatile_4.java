package net.sady.interview.thread;

import java.util.Scanner;

/**
 * Volatile - Volatile modifier guarantee that any thread thread reads a field
 * will see the most recently written value
 * 
 * @author sakhtar
 *
 */
class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		System.out.println("Thread Started...");
		while (running) {
			System.out.println("Running");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread Ended");
	}

	public void shutdown() {
		running = false;
	}
}

public class ThreadVolatile_4 {
	public static void main(String[] args) {

		Processor t1 = new Processor();
		t1.start();

		System.out.println("Enter Return to stop the thread...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		t1.shutdown();
	}
}
