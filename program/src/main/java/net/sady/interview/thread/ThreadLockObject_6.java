package net.sady.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Since synchronized will block the current object, Hence is taking more time.
 * We could have instead used lock object.
 * 
 * @author sakhtar
 *
 */
class WorkerMethodSynchronized {
	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public synchronized void addToList1() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		list1.add(random.nextInt(100));
	}

	public synchronized void addToList2() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		list2.add(random.nextInt(100));
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			addToList1();
			addToList2();
		}
	}

	public void main() {
		System.out.println("Starting...");

		Long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		Long end = System.currentTimeMillis();

		System.out.println("Time Taken : " + (end - start));
		System.out.println("List1 Size : " + list1.size());
		System.out.println("List2 Size : " + list2.size());
	}
}

class Worker {

	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	private void addToList1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}

			list1.add(random.nextInt(100));
		}
	}

	private void addToList2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}

			list2.add(random.nextInt(100));
		}
	}

	private void process() {
		for (int i = 0; i < 1000; i++) {
			addToList1();
			addToList2();
		}
	}

	public void main() {
		System.out.println("Worker Started...");

		Long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		Long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List 1: " + list1.size());
		System.out.println("List 2: " + list2.size());

	}
}

public class ThreadLockObject_6 {
	public static void main(String[] args) {
		new WorkerMethodSynchronized().main();
		
		new Worker().main();
	}

}
