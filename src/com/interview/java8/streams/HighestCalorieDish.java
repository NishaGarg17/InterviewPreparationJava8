package com.interview.java8.streams;

import java.util.Comparator;
import java.util.Optional;

import com.interview.java8.entity.Dish;
import com.interview.java8.entity.Menu;

public class HighestCalorieDish {

	public void printHighestCalorieDish(Menu menu) {
		Optional maxCalorieDish = menu.getMenu().stream().max(Comparator.comparing((Dish dish) -> dish.getCalories()));
		
		if(maxCalorieDish.isPresent()) {
			System.out.println("Max Calorie Dish is: " + maxCalorieDish.get());
		} else {
			System.out.println("No max Calorie Dish");
		}
		
	}

}
