package net.sady.hackerrank.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		
		ThreadDemoUsingAnnonymousClass annonymousClass = new ThreadDemoUsingAnnonymousClass();
		annonymousClass.main();

		ThreadDemoUsingLambda thread = new ThreadDemoUsingLambda();
		thread.main();
	}
}

class ThreadDemoUsingAnnonymousClass {
	public void main() {
		
		Thread t = new Thread() {

			@Override
			public void run() {
				System.out.println("Thread started");
			}
		};
		t.start();
	}
}

class ThreadDemoUsingLambda {
	public void main() {

		Thread t = new Thread(() -> System.out.println("Thread started using lambda"));

		t.start();
	}
}