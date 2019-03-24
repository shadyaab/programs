package net.sady.hackerrank;

import java.util.ArrayList;
import java.util.List;

class ThreadDemo implements Runnable{
	private static List<String> list;
	
	ThreadDemo(){
		list = new ArrayList<String>();
	}
	
	public void run() {
		System.out.println("Hello");
		//add();
		
	}
	private void add(String str) {
		list.add(str);
	}
	private void view() {
		list.stream()
			.forEach(System.out::print);
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadDemo());
		t1.start();
	}
	
}
