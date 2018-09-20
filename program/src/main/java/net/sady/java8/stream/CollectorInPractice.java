package net.sady.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorInPractice {

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
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		getUniqueMenuName(menu);
		getAllDishGroupByType(menu);
	}

	private static void getUniqueMenuName(List<Dish> menu) {
		Set<String> set = menu.stream()
				.map(Dish::getName)
				.collect(Collectors.toSet());
		System.out.println(set);
	}

	private static void getAllDishGroupByType(List<Dish> menu) {
		Map<Dish.Type, List<Dish>> map = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType));
		
		System.out.println(map);
		
		
	}
	
}
