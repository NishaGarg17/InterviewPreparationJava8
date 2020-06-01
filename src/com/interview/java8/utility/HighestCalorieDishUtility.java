package com.interview.java8.utility;

import com.interview.java8.entity.Menu;
import com.interview.java8.streams.HighestCalorieDish;

public class HighestCalorieDishUtility {

	public static void main(String[] args) {
		Menu menu = new Menu();
		
		HighestCalorieDish hcd = new HighestCalorieDish();
		hcd.printHighestCalorieDish(menu);
	}

}
