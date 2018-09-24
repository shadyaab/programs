package net.sady.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import net.sady.java8.stream.Dish;

public class OptionalInPractice {
	
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		Optional<Dish> opt = menu.stream()
				.filter(d -> d.getType().equals(Dish.Type.FISH))
				.findAny();
		
		Optional<Dish> opt2 = menu.stream()
				.filter(d -> d.getType().equals(Dish.Type.OTHER))
				.findAny();
		
		Optional<Dish> opt3 = null;
		
		System.out.println(opt.get());
		
		//Check if it is not null
		System.out.println(opt.isPresent());
		
		//It will not through exception instead will print Optional.empty
		System.out.println(opt2);
		
		//It will return null as string but not the exception
		System.out.println(opt3);
		
		Dish dish = opt3.orElse(new Dish("season fruit", true, 120, Dish.Type.OTHER));
		System.out.println(dish);
		
		
		
	}

}
