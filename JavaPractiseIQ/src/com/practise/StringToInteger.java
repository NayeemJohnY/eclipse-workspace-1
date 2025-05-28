package com.practise;

public class StringToInteger {
	
	// 1. without using parseInt
	
	public static void StringToNumber(String str) {
		int number = 0;
		for(char c : str.toCharArray()) {
			if(c !='-')
//			 number = number *10 + c-48;
				number = number *10 + c-(int)'0';
		}
		if(str.contains("-"))
			number = number *-1;
		System.out.println(number);
		System.out.println("Added with 10 : "+ (number+10));
	}

	public static void main(String[] args) {
		StringToNumber("2345");
		StringToNumber("189900");
		StringToNumber("0");
		StringToNumber("-3456");
	}

}
