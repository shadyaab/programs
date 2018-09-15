package net.sady.java8.stream;

import java.util.stream.IntStream;

public class NumericRange {
	
	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100)
				.filter(i -> i%2 == 0);
				
		System.out.println(stream.sum());
		System.out.println(stream.count());
		System.out.println(stream.max());
	}

}
