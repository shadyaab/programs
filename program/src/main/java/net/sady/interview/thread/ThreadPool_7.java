package net.sady.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerThread implements Runnable{
	
	private Random random = new Random();
	public List<Integer> list1 = new ArrayList<>();
	public List<Integer> list2 = new ArrayList<>();

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	private void addToList1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}

			list1.add(random.nextInt(100));
		}
	}

	private void addToList2() {
		synchronized(lock2) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		list2.add(random.nextInt(100));
		}
	}

	private void process() {
		for (int i = 0; i < 1000; i++) {
			addToList1();
			addToList2();
		}
	}

	public void run() {
		process();
	}
	
}


public class ThreadPool_7{
	public static void main(String[] args){

		System.out.println("Started...");
		long start = System.currentTimeMillis();

		ExecutorService executor = Executors.newFixedThreadPool(2);
		WorkerThread worker = new WorkerThread();
		for (int i = 0; i < 2; i++) {
			executor.submit(worker);
		}

		executor.shutdown();

		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
		}

		long end = System.currentTimeMillis();

		System.out.println("Time Taken: " + (end - start));
		System.out.println("List1: " + worker.list1.size());
		System.out.println("List2: " + worker.list2.size());
	}
}
