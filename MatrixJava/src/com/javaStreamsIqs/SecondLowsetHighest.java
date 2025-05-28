package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLowsetHighest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 0, -4, -9, 10, 30, 40, 39, 30, 40);
		int secondMax = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
		int secondMin = list.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println(secondMax);
		System.out.println(secondMin);

	}

}
