package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintOddEvenNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> evenList = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println(evenList);
		List<Integer> oddList = list.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
		System.out.println(oddList);

	}

}
