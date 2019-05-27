package net.sady.interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Connection {
	private Semaphore sem = new Semaphore(10);
	private static Connection instance = new Connection();
	private int noOfConnection;
	
	private Connection() {}
	
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
			synchronized(this) {
				noOfConnection++;
				System.out.println("current connection: " + noOfConnection);
			}
			
			Thread.sleep(2000);
			
			synchronized (this) {
				noOfConnection--;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(sem != null) {
				sem.release();
			}
		}
		
		
	}
}


public class ThreadSemaphore {

	public static void main(String[] args) {
		//Semaphore sem = new Semaphore(3);
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0; i< 300; i++) {
			executor.submit(new Runnable() {
				
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		
	}
	
}
