package net.sady.java8.behaviorasvalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


class AppleUtilityDemo{
	public List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple: appleList) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}


public class AppleDemo {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>(
				Arrays.asList(new Apple(1,"green", 25), 
					      new Apple(2, "red", 40),
					      new Apple(3, "green", 40),
					      new Apple(4, "red", 60),
					      new Apple(5, "blue", 50))); 
		
		AppleUtilityDemo utility = new AppleUtilityDemo();
		List<Apple> filterList = utility.filterApple(appleList, apple -> apple.getColor().equals("green"));
		System.out.println(filterList);
	}
	
}