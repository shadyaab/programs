package net.sady.interview.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Any thread, usually main thread of application, which calls awaits
 * will wait until count reaches zero or its interrupted
 * by another thread. All other thread are required to do count down by calling
 * once they are completed or ready.
 * 
 * @author sakhtar
 *
 */
class ProcessorThread implements Runnable {

	private CountDownLatch latch;

	public ProcessorThread(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("Started...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		System.out.println("End");
		latch.countDown();
	}
}

public class ThreadCountDownLatch_8 {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		ProcessorThread worker = new ProcessorThread(latch);

		for (int i = 0; i < 3; i++) {
			executor.submit(worker);
		}

		executor.shutdown();

		try {
			latch.await();
		} catch (InterruptedException e) {
		}
		System.out.println("Completed");
	}

}
