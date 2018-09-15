package net.sady.java8.behaviorasvalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface ApplePredicate{
	boolean test(Apple apple);
}
class AppleGreenColorPredicate implements ApplePredicate{
	
	public boolean test(Apple apple) {
		return apple.getColor().equalsIgnoreCase("green");
	}
}

class AppleUtility2{
	public List<Apple> filterApple(List<Apple> appleList, ApplePredicate p) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple: appleList) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}


public class Apple2Test {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>(
				Arrays.asList(new Apple(1,"green", 25), 
					      new Apple(2, "red", 40),
					      new Apple(3, "green", 40),
					      new Apple(4, "red", 60),
					      new Apple(5, "blue", 50))); 
		
		AppleUtility2 utility = new AppleUtility2();
		List<Apple> filterList = utility.filterApple(appleList, new AppleGreenColorPredicate());
		System.out.println(filterList);
	}
}




