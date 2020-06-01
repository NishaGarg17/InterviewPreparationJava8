package com.interview.java8.streams;

import java.util.Arrays;
import java.util.List;;

public class UniqueCharsInList {

	public static void main(String args[]) {
		List<String> words = Arrays.asList("Hello", "World");

		words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(str -> System.out.println(str));

	}
}
