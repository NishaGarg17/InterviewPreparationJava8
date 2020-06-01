package com.interview.java8.streams;

import java.util.stream.Stream;

public class StreamGenerate {

	public static void main(String[] args) {
		Stream.generate(Math :: random).limit(10).forEach(temp -> System.out.println(temp));

	}

}
