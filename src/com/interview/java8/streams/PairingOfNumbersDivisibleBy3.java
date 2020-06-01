package com.interview.java8.streams;

import java.util.Arrays;
import java.util.List;

public class PairingOfNumbersDivisibleBy3 {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		
		list1.stream().flatMap(i -> list2.stream().filter(j -> ((i+j) % 3 == 0)).map(j -> new int[] {i,j})).forEach(arr -> System.out.println(Arrays.toString(arr)));
		


	}

}
