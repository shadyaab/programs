package net.sady.java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BufferedReaderAsFunctionalProgramming {
	
	private static final String filePath = "C:\\Users\\sakhtar\\git\\programs\\program\\src\\main\\java\\net\\sady\\java8\\data.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//System.out.println(processFile());
		System.out.println(processFile((BufferedReader br) -> br.readLine()));
		System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));
	}
	
	public static String processFile(BufferedReaderProcessor p) throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			//return br.readLine();
			return p.process(br);
		}
	}
	
	interface BufferedReaderProcessor{
		String process(BufferedReader br) throws FileNotFoundException, IOException;
	}
}





