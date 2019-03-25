package net.sady.interview.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadProducerConsumerUsingQueue {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	private static void producer() {
		Random random = new Random();
		try {
			queue.put(random.nextInt(100));
		} catch (InterruptedException e) {
		};
	}
	private static void consumer() {
		
		
		
		  
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				producer();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				consumer();
			}
		});
		
		t1.start();
		t2.start();
	}
	
	
	
	

}
