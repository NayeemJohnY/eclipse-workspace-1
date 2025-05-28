package com.matrix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Matrix_Mutliplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Total Rows in Matrix 1 : ");
		int rows = scan.nextInt();

		System.out.println("Enter Total Columns in Matrix 1 : ");
		int columns = scan.nextInt();

		int matrix1[][] = new int[rows][columns];
		System.out.println("Enter Matrix1 Data : ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix1[i][j] = scan.nextInt();
			}
		}
		System.out.println("Enter Total Rows in Matrix 2 : ");
		int matrix2Rows = scan.nextInt();

		System.out.println("Enter Total Columns in Matrix 2 : ");
		int matrix2Columns = scan.nextInt();

		int matrix2[][] = new int[matrix2Rows][matrix2Columns];
		if (columns != matrix2Rows) {
			System.out.println("Cannot perfrom Mutliplication");
		} else {
			System.out.println("Enter Matrix2 Data : ");
			for (int i = 0; i < matrix2Rows; i++) {
				for (int j = 0; j < matrix2Columns; j++) {
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

			System.out.println("Multiplication");
			int product[][] = new int[rows][matrix2Columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < matrix2Columns; j++) {
					for(int k = 0 ; k < matrix2Rows; k++) {
						product[i][j]+= matrix1[i][k]* matrix2[k][j];
					}
				}
			}
			for (int[] is : product) {
				System.out.println(Arrays.toString(is));
			}
		}
	}

}
