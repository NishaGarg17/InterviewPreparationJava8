package com.interview.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfListElements {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,4,5,6);
		
		// to print the sum of elements of the list using reduce operation having initial value
		
		System.out.println("Sum is: " + list.stream().reduce(0, (a,b) -> a + b));
		
		// to print the sum of elements of the list using reduce operation without using initial value
		
		//List<Integer> list1 = new ArrayList<Integer>();
		Optional sum = list.stream().reduce(Integer :: sum);
		
		sum.ifPresent(s -> System.out.println("Sum is: " + s));

	}

}
