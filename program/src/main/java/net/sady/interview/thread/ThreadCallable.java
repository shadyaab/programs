package net.sady.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class CallableImpl implements Callable<Integer> {

	public Integer call() throws Exception {
		Random random = new Random();
		return random.nextInt(100);
	}
}

public class ThreadCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Future<Integer>> futureList = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		CallableImpl task = new CallableImpl();
		for (int i = 0; i < 3; i++) {
			futureList.add(executor.submit(task));
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
		}
	
		for(Future<Integer> future: futureList) {
			System.out.println(future.get());
		}
		
	}

}
