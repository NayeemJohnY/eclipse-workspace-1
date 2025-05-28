package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.List;

public class SumOfNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sum = list.stream().reduce((a, b) -> a+b).get();
		System.out.println("Sum of numbers using Stream reduce : "+ sum);
	}

}
