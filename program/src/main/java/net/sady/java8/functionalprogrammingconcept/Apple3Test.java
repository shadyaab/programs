package net.sady.java8.functionalprogrammingconcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface ApplePredicate3{
	boolean test(Apple apple);
}

class AppleUtility3{
	public List<Apple> filterApple(List<Apple> appleList, ApplePredicate3 p) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple: appleList) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}


public class Apple3Test {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>(
				Arrays.asList(new Apple(1,"green", 25), 
					      new Apple(2, "red", 40),
					      new Apple(3, "green", 40),
					      new Apple(4, "red", 60),
					      new Apple(5, "blue", 50))); 
		
		AppleUtility3 utility = new AppleUtility3();
		List<Apple> filterList = utility.filterApple(appleList, (Apple apple) -> apple.getColor().equalsIgnoreCase("green"));
		System.out.println(filterList);
	}
}




