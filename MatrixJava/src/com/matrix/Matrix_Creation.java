package com.matrix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Matrix_Creation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Total Rows : ");
		int rows = scan.nextInt();

		System.out.println("Enter Total Columns : ");
		int columns = scan.nextInt();

		int matrix[][] = new int[rows][columns];
		System.out.println("Enter Matrix Data : ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}

		System.out.println("Matrix Values");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Matrix Values -2 ");
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}
		System.out.println("Matrix Values -3 ");
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("Matrix Values -4");
		System.out.println(Arrays.deepToString(matrix));
		
		System.out.println("Matrix Values -5");
		Arrays.stream(matrix).forEach(row->{
			Arrays.stream(row).forEach(System.out::print);
			System.out.println(" ");
		});
		
		
		
	}

}
