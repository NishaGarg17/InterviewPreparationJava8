package com.interview.java8.streams;

import static java.util.stream.Collectors.toList;
import java.util.List;
import com.interview.java8.entity.Dish;
import com.interview.java8.entity.Menu;

public class LowCaloricDishes {

	public List<String> findLowCaloricDishes(Menu menu) {
		 return menu.getMenu().stream()
		 .filter(dish -> (dish.getCalories() < 400))
		 .map(dish -> dish.getName())
		 .collect(toList());
	}

}
