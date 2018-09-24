package net.sady.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStream {
	
	public static final String FILE_URL = "C:\\Users\\sakhtar\\git\\programs\\program\\src\\main\\java\\net\\sady\\java8\\stream\\data.txt";

	public static void main(String[] args) {
		streamFromValues();
		streamFromArray();
		streamFromFile();
		
		//Infinite stream
		streamIterate();
		streamGenerate();
		
		//calculate sum of number in array
		int arr []= {3,5,6,7,3};
		streamFromArrayAndCalculateSum(arr);
	}

	

	//It doesnot apply functional on the produced value.
	private static void streamGenerate() {
		Stream
			.generate(Math::random)
			.limit(4)
			.forEach(System.out::println);
	}

	private static void streamIterate() {
		Stream
			.iterate(0, n-> n+2)
			.limit(20)
			.forEach(System.out::println);
	}

	private static void streamFromFile() {
	
		try(Stream<String> lines = Files.lines(Paths.get(FILE_URL),Charset.defaultCharset())){		
			lines
				.flatMap(l -> Arrays.stream(l.split(" ")))
				.distinct()
				.forEach(System.out::println);
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void streamFromArray() {
		int [] numbers = {1,2,3,4,5,6};
		IntStream stream = Arrays
				.stream(numbers);
		
		stream.forEach(System.out::println);
	}

	private static void streamFromValues() {
		Stream<String> stream = Stream.of("Red","Green","Blue");
		Boolean b = stream
					.anyMatch(t -> t.equals("Red"));
			
		System.out.println(b);
	}
	
	private static void streamFromArrayAndCalculateSum(int[] arr) {
		//Array stream return int stream
		int sum = Arrays.stream(arr)
				.reduce(0, (a, b) -> a+b);
		System.out.println(sum);
	}
	
}
