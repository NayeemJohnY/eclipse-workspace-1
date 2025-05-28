package com.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatternsLogic {

	public void jpmorgan_program() throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);

		BufferedReader bufferedReader = new BufferedReader(in);
		String line;

		while ((line = bufferedReader.readLine()) != null && line != "") {
			String output = "";
			int number = 0;
			for (char character : line.toCharArray()) {
				if (character >= 'a' && character <= 'j') {
					number = (int) character - 'a';
					output += number;
				}
			}
			if (output.isEmpty()) {
				System.out.println("NONE");
			} else {
				System.out.println(output);
			}
		}
	}

	public void patternLogic1() {
		int number = 5;
		for (int i = 0; i < number; i++) {
			for (int j = i; j < number; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < number - 1; i++) {
			for (int j = i; j < number - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			int j = 0;
			for (; j < number - i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = j; k < number; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = number - i; k <= number; k++) {
				System.out.print("*");
				if (k < number)
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k < number; k++) {
				System.out.print("*");
				if (k < number - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			char ch = 'A';
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					System.out.print((char) (ch + j));
				else
					System.out.print(" " + (char) (ch + j));
			}
			for (int k = 0; k <= i; k++) {

			}
			System.out.println();
		}
		System.out.println("========================================================");
		for (int i = 0; i < number; i++) {
			char ch = (char) ('A' + i);
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					System.out.print(ch);
				else
					System.out.print(" " + ch);
			}
			for (int k = 0; k <= i; k++) {

			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {

		PatternsLogic patternsLogic = new PatternsLogic();
		patternsLogic.patternLogic1();
//		patternsLogic.jpmorgan_program();
	}

}
