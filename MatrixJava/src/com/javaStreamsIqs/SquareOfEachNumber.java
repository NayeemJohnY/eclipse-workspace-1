package com.javaStreamsIqs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfEachNumber {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> squareList = list.stream().map(e -> e * e).collect(Collectors.toList());
		System.out.println(squareList);

		double averageOfSquares = list.stream().map(e -> e * e).mapToInt(e -> e).average().getAsDouble();
		System.out.println(averageOfSquares);

		// Get average of more than 10
		averageOfSquares = list.stream().map(e -> e * e).filter(e -> e > 10).mapToInt(e -> e).average().getAsDouble();
		System.out.println(averageOfSquares);

	}

}
