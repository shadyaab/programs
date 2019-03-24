package net.sady.hackerrank.thread;


class RunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Runnable thread started: " + Thread.currentThread().getName());
		try {
			doHeavyProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Runnable thread ended: " + Thread.currentThread().getName());
	}

	private void doHeavyProcessing() throws InterruptedException {
		Thread.sleep(3000);
	}
}

class ExtendThreadImpl extends Thread{
	
	public ExtendThreadImpl(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("ExtendThreadImpl thread started: " + Thread.currentThread().getName());
		try {
			doHeavyProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ExtendThreadImpl thread ended: " + Thread.currentThread().getName());
	}

	private void doHeavyProcessing() throws InterruptedException {
		Thread.sleep(3000);
	}
}


public class RunnableVsThread {
	
	public static void main(String[] args) {
		
		System.out.println("Main thread started");
		Thread t1 = new Thread(new RunnableThread(), "thread1");
		Thread t2 = new Thread(new RunnableThread(), "thread2");
		t1.start();
		t2.start();
		System.out.println("Runnable thread has been started");
		
		Thread t3 = new ExtendThreadImpl("thread3");
		Thread t4 = new ExtendThreadImpl("thread4");
		t3.start();
		t4.start();
		
		System.out.println("ExtendThreadImpl has been started");
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------Main thread ended");
		
	}
	

}












