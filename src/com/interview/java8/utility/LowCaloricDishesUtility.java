package com.interview.java8.utility;

import java.util.List;

import com.interview.java8.entity.Menu;
import com.interview.java8.streams.LowCaloricDishes;

public class LowCaloricDishesUtility {
	public static void main(String args[]) {
		Menu menu = new Menu();
		LowCaloricDishes lcd = new LowCaloricDishes();
		System.out.println("Menu is: " + menu.getMenu());
		
		// call to Low Caloric Dishes class to get low calorie dishes
		List<String> lowCalorieDishes = lcd.findLowCaloricDishes(menu);
		
		// to print lowCalorieDishes
		lowCalorieDishes.forEach(dish -> System.out.println(dish));
		
	}
}
