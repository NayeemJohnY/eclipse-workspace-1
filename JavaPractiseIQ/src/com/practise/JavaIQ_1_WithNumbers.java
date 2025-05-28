package com.practise;

import java.util.Arrays;
import java.util.stream.IntStream;

public class JavaIQ_1_WithNumbers {
	
	public void shiftingzeroElements() {
		int num [] = {1,2,0, 3,0,0,6,3,0,1,0,1, 0};
		int shiftedArray[] = new int[num.length];
		int zerosCount = 0;
		for (int number : num) {
			if (number == 0) {
				zerosCount++;
			}
		}
		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0) {
				shiftedArray[zerosCount++]= num[i];
			}
		}
		System.out.println(Arrays.toString(shiftedArray));
		
	}
	
	public void printNumberUsingRecursive(int start, int end) {
		if (start <= end) {
			System.out.println(start);
			printNumberUsingRecursive(++start, end);
		}

	}
	
	public void printNumbersWithoutLoops() {
		System.out.println("*********************** Numbers Without Loops ************************");
		// 1. Using recursive function
		// 2. Java Streams
		printNumberUsingRecursive(101, 200);
		IntStream.range(1, 101).forEach(System.out::println);
		
	}
	
	public void intergerCaching() {
		System.out.println("*********************** Interger Caching ************************");
		// Auto Boxed when number is -128 to 127 even the object equals operator used
		Integer num1 = 100;
		Integer num2 = 100;
		System.out.println(num1 == num2); // true
		num1 = 140; num2= 140;
		System.out.println(num1 == num2); // false
		num1 = -128; num2= -128;
		System.out.println(num1 == num2); // true
		num1 = -129; num2= -129;
		System.out.println(num1 == num2); // false
	}
	
	public void divideByZero() {
		System.out.println("*********************** Divide By Zero ************************");
		System.out.println(9.0/0); // Infinity
		System.out.println(10/0.0); //Infinity
		System.out.println(10.0f/0.0); //Infinity
		System.out.println(999990.0d/0.0);// Infinity
		System.out.println(0.0/0);//NaN
//		System.out.println(0/0);
//		Arithmetic exception only with Intergers
	}
	
	public void nan_number() {
		/*
		 * NaN - Not a Number Not defined as number
		 * NaN is not defined in C it is negative number
		 * Comparing 2 NaN is false since both a undefined number
		 */
//		System.out.println(2/0); //Arithmetic Exception
		System.out.println(2.0 / 0.0); // Infinity
		System.out.println(0.0 / 0.0); // NaN in JS too
		System.out.println(Math.sqrt(-1)); // NaN in JS too
		System.out.println(Float.NaN == Float.NaN); // false
		double num = 2.1 % 0;
		System.out.println(num); // NaN
		System.out.println(num == Float.NaN); // false
		System.out.println(num == num); //false
		
	}
	
	

	public static void main(String[] args) {
		JavaIQ_1_WithNumbers iq_1 = new JavaIQ_1_WithNumbers();
		iq_1.nan_number();
		iq_1.divideByZero();	
		iq_1.intergerCaching();
		iq_1.printNumbersWithoutLoops();
		iq_1.shiftingzeroElements();
	}

}
