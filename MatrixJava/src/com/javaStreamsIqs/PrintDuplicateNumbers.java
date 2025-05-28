package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicateNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,1, 2, 3, 14, 14, 5, 6,7, 9, 9);
		Set<Integer> setDuplicate = list.stream().filter(e-> Collections.frequency(list, e)> 1).collect(Collectors.toSet());
		System.out.println(setDuplicate);
		
		Set<Integer> dupli = new HashSet<Integer>();
		setDuplicate = list.stream().filter(e-> !dupli.add(e)).collect(Collectors.toSet());
		System.out.println(setDuplicate);
	}

}
