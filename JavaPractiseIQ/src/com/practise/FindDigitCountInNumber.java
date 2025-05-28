package com.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class FindDigitCountInNumber {
	
	public static void findDigitCount_method_1(long number) {
		HashMap<Long, Integer> digitCountMap = new HashMap<>();
		while(number != 0 ) {
			long rem = number%10;
			if (digitCountMap.containsKey(rem)) {
				digitCountMap.put(rem, digitCountMap.get(rem) + 1);
			} else {
				digitCountMap.put(rem, 1);
			}
			number = number /10;
		}
		System.out.println(digitCountMap);
	}
	
	public static void findDigitCount_method_2(long number) {
		for(int i = 0 ; i <= 9; i++) {
			int count = 0;
			long tempNumber = number;
			while(tempNumber != 0 ) {
				long rem = tempNumber%10;
				if (rem == i) {
					count++;
				}
				tempNumber = tempNumber /10;
			}
			if (count !=0) {
				System.out.println("Digit : "+ i +" Count : " + count);	
			}
			
		}
	}
	
	public static void findDigitCount_method_3(long number) {
		String numberString = String.valueOf(number);
		int numberArray[] = new int[10];
		char[] numbercharArray = numberString.toCharArray();
		for(char c : numbercharArray) {
			if(c!= '-')
			numberArray[c-48]++;
		}
		
		for(int i = 0 ; i<numberArray.length; i++) {
			if (numberArray[i] != 0) {
				System.out.println("Digit : "+ i +" Count : " + numberArray[i]);		
			}
			
		}
	}

	public static void main(String[] args) {
		
		findDigitCount_method_1(1000000);
		findDigitCount_method_1(-232345678);
		findDigitCount_method_2(0001);
		findDigitCount_method_2(1222221333);
		findDigitCount_method_3(-88854321);
	}

}
