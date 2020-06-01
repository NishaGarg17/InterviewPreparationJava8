package com.interview.java8.streams;

import java.util.Arrays;
import java.util.List;

public class PairingOfNumbersUsingStreams {

	public static void main(String[] args) {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i,j})).forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

}
