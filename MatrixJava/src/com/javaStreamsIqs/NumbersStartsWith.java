package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersStartsWith {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 2, 23, -220, 25, 226, 12, 723, 3321);
		List<String > listString = list.stream().map(e-> String.valueOf(e)).filter(e-> e.startsWith("2")).collect(Collectors.toList());
		System.out.println(listString);
		list = list.stream().map(e-> String.valueOf(e)).filter(e-> e.startsWith("-2") || e.startsWith("2")).map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(list);
	}

}
