package net.sady.interview.thread;

class Runner extends Thread {
	
	//Set name for current thread
	public Runner(String name){
		super(name);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello " + i + " Thread: " + Thread.currentThread().getName());	
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadExtends_1 {
	public static void main(String[] args) {
		Runner t1 = new Runner("Thread_1");
		t1.start();
		
		Runner t2 = new Runner("Thread_2");
		t2.start();
	}

}
