package net.sady.interview.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class OlaCab extends Thread {

	private CyclicBarrier barrier;
	private int duration;
	
	public OlaCab(CyclicBarrier barrier, String name, int duration) {
		super(name);
		this.barrier = barrier;
		this.duration = duration;
	}
	
	public void run() {
		try {
			Thread.sleep(2*duration);
			System.out.println(Thread.currentThread().getName() + " has arrived");
			int await = barrier.await();
			if(await == 0) {
				System.out.println("Three passenger has arrived so starting the cab");
			}
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
}

public class ThreadCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		OlaCab obj1 = new OlaCab(barrier, "Raj", 1000);
		OlaCab obj2 = new OlaCab(barrier, "Sri", 3000);
		OlaCab obj3 = new OlaCab(barrier, "Sady", 5000);
		
		OlaCab obj4 = new OlaCab(barrier, "A", 2000);
		OlaCab obj5 = new OlaCab(barrier, "B", 4000);
		OlaCab obj6 = new OlaCab(barrier, "C", 6000);
		
		obj1.start();
		obj2.start();
		obj3.start();
		
		obj4.start();
		obj5.start();
		obj6.start();			
	}
	
}
