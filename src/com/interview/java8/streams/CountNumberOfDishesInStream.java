package com.interview.java8.streams;

import com.interview.java8.entity.Menu;

public class CountNumberOfDishesInStream {

	public static void main(String[] args) {
		Menu menu = new Menu();
		
		System.out.println("Total number of dishes in menu are: " + 
		menu.getMenu().stream().map(dish -> dish.getCalories()).reduce(0, (a,b) -> a + 1));
		
		// method 2 by mapping each dish to 1
		System.out.println("Total number of dishes in menu are: " + 
				menu.getMenu().stream().map(dish -> 1).reduce(0, (a,b) -> a + b));
		
		// method 3 using built in method
		System.out.println("Total number of dishes in menu are: " + menu.getMenu().stream().count());
		
	}

}
	