package net.sady.hackerrank.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(2000);

		return Thread.currentThread().getName();
	}
}

public class CallableThread {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future<String>> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(new MyCallable());
			list.add(future);  
		}
		for(Future<String> future: list) {
			try {
				System.out.println(new Date() + " : " + future.get());
				
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 
		}
		
		executorService.shutdown();

	}

}
