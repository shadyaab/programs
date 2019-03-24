package net.sady.hackerrank.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Started Executing");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " Excecution ended" );
	}
}


public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 10; i++) {
			Thread thread = new Thread(new WorkerThread(), "thread" + i);
			executor.execute(thread);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
	}
}






