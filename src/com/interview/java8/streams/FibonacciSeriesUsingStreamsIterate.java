package com.interview.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class FibonacciSeriesUsingStreamsIterate {

	public static void main(String[] args) {
		System.out.println("Fibonacci Series Using Stream.iterate: ");
		Stream.iterate(new int[] {0,1}, arr -> new int[] {arr[1], arr[0] + arr[1]})
		.limit(20).forEach(arr -> System.out.println(Arrays.toString(arr)));
		
		System.out.println("Fibonacci Series Using Stream.iterate: ");
		Stream.iterate(new int[] {0,1}, arr -> new int[] {arr[1], arr[0] + arr[1]})
		.limit(20).forEach(arr -> System.out.println(arr[0]));
	}

}
