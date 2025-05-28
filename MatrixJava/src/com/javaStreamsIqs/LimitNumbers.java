package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitNumbers {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,1, 2, 3, 14, 14, -5, 6,7, 9, 9);
		list = list.stream().limit(5).collect(Collectors.toList());
		
		System.out.println(list);
		list = list.stream().skip(3).collect(Collectors.toList());
		System.out.println(list);
		
		
	}
	
	

}
