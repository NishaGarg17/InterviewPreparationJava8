package com.interview.java8.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class SquareUsingStreams {

	public static void main(String[] args) {
		// call to a calculate square method to find out the square of each element
		List<Integer> outputList =calculateSquare(Arrays.asList(1,2,3,4,5));
		outputList.forEach(System.out::println);
	}
	
	public static List<Integer> calculateSquare(List<Integer> inputList) {
			return inputList.stream().map(i -> i * i).collect(toList());
	}

}
