package net.sady.java8.stream;

import java.util.Arrays;
import java.util.List;

import net.sady.java8.stream.Dish;

public class ReduceInPractice {
	
	public static void main(String[] args) {
	
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		countElements(menu);
		
		//Calculate total calories
		sumCalories(menu);
		
		maxCalory(menu);
		
		 
	}

	private static void sumCalories(List<Dish> menu) {
		
		int x=4;
		int sum =  menu.stream()
			 	.map(d -> d.getCalories())
				.reduce(0,(a,b) -> a+b + x);
	 
		System.out.println(sum);
	}
	
	private static void countElements(List<Dish> menu) {
		int count = menu.stream()
			 	.map(d -> 1)
				.reduce(0,(a,b) -> a+b);
		
		System.out.println(count);
	}
	
	private static void maxCalory(List<Dish> menu) {
		int max =  menu.stream()
			 	.map(d -> d.getCalories())
				.reduce(0, (a,b) -> a>b?a:b);
	 
		System.out.println(max);
	}

}
