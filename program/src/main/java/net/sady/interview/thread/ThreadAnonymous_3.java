package net.sady.interview.thread;

public class ThreadAnonymous_3 {
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Hello " + i + " Thread: " + Thread.currentThread().getName());
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "Thread_1");
		
		t1.start();

	}

}
