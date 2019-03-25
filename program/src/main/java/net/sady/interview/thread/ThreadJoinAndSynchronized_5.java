package net.sady.interview.thread;

/**
 * Without synchronization, the final count will be inconsistent
 * In order to make the count consistent we have to use
 * synchronized block
 * 
 * @author sakhtar
 *
 */
public class ThreadJoinAndSynchronized_5 {
	
	private int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		ThreadJoinAndSynchronized_5 worker = new ThreadJoinAndSynchronized_5();
		worker.doWork();
	}
	
	private synchronized void doIncrement() {
		count++;
	}

	private void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Started...");
				for(int i = 0; i<5; i++) {
					doIncrement();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Started...");
				for(int i = 0; i< 5; i++) {
					doIncrement();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {}
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count: " + count);
	}

}
