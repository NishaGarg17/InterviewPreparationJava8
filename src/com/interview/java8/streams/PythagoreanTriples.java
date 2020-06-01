package com.interview.java8.streams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PythagoreanTriples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the value for a: ");
		int a = sc.nextInt();
		
		// to find a possible pythagorean triple for a given value of a
		System.out.println("Possible pythagorea triples");
		IntStream.rangeClosed(1, 100).filter(b -> (Math.sqrt(a*a + b*b)) % 1 == 0).boxed()
		.map(b -> new int[] {a,b,(int) Math.sqrt(a*a + b*b)})
		.forEach(arr -> System.out.println(Arrays.toString(arr)));
		
		// Better way to achieve the same as above			
		System.out.println("Possible pythagorea triples with some better code: ");
		IntStream.rangeClosed(1, 100).filter(b -> (Math.sqrt(a*a + b*b)) % 1 == 0)
		.mapToObj(b -> new int[] {a,b,(int) Math.sqrt(a*a + b*b)})
		.forEach(arr -> System.out.println(Arrays.toString(arr)));
		
		// assume a can't be user defined
		System.out.println("Possible pythgorean triples from 1 to 100: ");
		IntStream.rangeClosed(1, 100).boxed().flatMap(b -> IntStream.rangeClosed(b, 100)
		.filter(c -> Math.sqrt(b * b + c * c) % 1 == 0).mapToObj(c -> new int[] {b, c, (int) Math.sqrt(b * b + c * c)}))
		.forEach(arr -> System.out.println(Arrays.toString(arr)));
		
		// remove the duplicate use of Math.sqrt
		System.out.println("Possible pythgorean triples from 1 to 100: ");
		IntStream.rangeClosed(1, 100).boxed().flatMap(b -> IntStream.rangeClosed(b, 100)
		.mapToObj(c -> {
			if(Math.sqrt(b * b + c * c) % 1 == 0) { 
				return new int[] {b, c, (int) Math.sqrt(b * b + c * c)};
			}
			return null;})).filter(arr -> arr != null)
		 .forEach(arr -> System.out.println(Arrays.toString(arr)));
		
		//  remove the duplicate use of Math.sqrt with some better code
		
		IntStream.rangeClosed(1, 100).boxed().flatMap(b -> IntStream.rangeClosed(b, 100).mapToObj(c -> new double[] {b, c, Math.sqrt(b * b + c * c)}))
		.filter(arr -> (arr[2] % 1 == 0)).forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

}
