package net.sady.interview.thread;

class RunnerThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i< 5; i++) {
			System.out.println("Hello " + i + " Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class ThreadRunnable_2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnerThread(), "Thread_1");
		t1.start();
		
		Thread t2 = new Thread(new RunnerThread(), "Thread_2");
		t2.start();
	}
}
