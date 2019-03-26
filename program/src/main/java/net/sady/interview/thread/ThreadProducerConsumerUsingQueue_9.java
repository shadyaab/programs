package net.sady.interview.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadProducerConsumerUsingQueue_9 {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			
			//If Queue is full waits
			queue.put(random.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			if(random.nextInt(10) == 0) {
				Integer value = queue.take();
				System.out.println("Taken Value: "  + value + "; Queue size : " + queue.size());
			}
		}
		
		
		  
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		
		System.exit(0);	
	}
}
