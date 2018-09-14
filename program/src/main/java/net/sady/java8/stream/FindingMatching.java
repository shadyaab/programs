package net.sady.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingMatching {
	
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
	
		anyMatch(menu);
		
		allMatch(menu);
		
		noneMatch(menu);
		
		//arbitrary element of the current stream
		findAny(menu);
		
		//findFirst(menu);
		
		findAnyWithIfPresent(menu);
	}
	
	public static void anyMatch(List<Dish> menu){
		Boolean b = menu.stream()
						.anyMatch(Dish::isVegetarian);
		
		System.out.println(b);
	}
	
	private static void allMatch(List<Dish> menu) {
		Boolean b = menu.stream()
			.allMatch(d -> d.getCalories() < 1000);
		
		System.out.println(b);
	}
	
	private static void noneMatch(List<Dish> menu) {
		Boolean b = menu.stream()
			.noneMatch(d -> d.getCalories() < 1000);
		
		System.out.println(b);
	}
	
	private static void findAny(List<Dish> menu) {
		Optional<Dish> b = menu.stream()
			.filter(d -> d.isVegetarian())
			.findAny();
		if(b.isPresent()){
			System.out.println(b);
		}
		
	}
	
	private static void findAnyWithIfPresent(List<Dish> menu) {
		menu.stream()
			.filter(Dish::isVegetarian)
			.findAny()
			.ifPresent(d -> System.out.println(d.getName()));
			
	}
}
















