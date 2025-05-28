package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.List;

public class AverageOfNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sum = list.stream().reduce((a, b) -> a+b).get();
		System.out.println("Average of numbers using Stream reduce : "+ sum/list.size());
		
		double average = list.stream().mapToInt(e -> e).average().getAsDouble();
		System.out.println("Average of numbers using Stream maptoInt : "+ average);
	}

}
