package com.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Addition_Subtraction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Total Rows : ");
		int rows = scan.nextInt();

		System.out.println("Enter Total Columns : ");
		int columns = scan.nextInt();

		int matrix1[][] = new int[rows][columns];
		System.out.println("Enter Matrix1 Data : ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix1[i][j] = scan.nextInt();
			}
		}
		int matrix2[][] = new int[rows][columns];
		System.out.println("Enter Matrix2 Data : ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix2[i][j] = scan.nextInt();
			}
		}
		System.out.println("Matrix 1");
		for (int[] is : matrix1) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("Matrix 2");
		for (int[] is : matrix2) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("Addition");
		int sumMatrix[][] = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sumMatrix[i][j] = matrix1[i][j]+ matrix2[i][j];
				System.out.print(sumMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Subtraction");
		int subMatrix[][] = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				subMatrix[i][j] = matrix1[i][j]- matrix2[i][j];
				System.out.print(subMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
