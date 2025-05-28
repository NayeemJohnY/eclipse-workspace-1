package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMinNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,1, 2, 3, 14, 14, -5, 6,7, 9, 9);
		int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(max);
		int min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(min);
	}

}
