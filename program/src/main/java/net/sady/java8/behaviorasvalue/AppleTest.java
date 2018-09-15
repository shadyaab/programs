package net.sady.java8.behaviorasvalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AppleUtility{
	public List<Apple> filterApple(List<Apple> appleList) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple: appleList) {
			if(apple.getColor().equalsIgnoreCase("green")) {
				result.add(apple);
			}
		}
		return result;
	}
}


public class AppleTest {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>(
				Arrays.asList(new Apple(1,"green", 25), 
					      new Apple(2, "red", 40),
					      new Apple(3, "green", 40),
					      new Apple(4, "red", 60),
					      new Apple(5, "blue", 50))); 
		
		AppleUtility utility = new AppleUtility();
		List<Apple> filterList = utility.filterApple(appleList);
		System.out.println(filterList);
	}
	
	
	
}




