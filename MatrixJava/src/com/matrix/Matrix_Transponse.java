package com.matrix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Matrix_Transponse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Total Rows : ");
		int rows = scan.nextInt();

		System.out.println("Enter Total Columns : ");
		int columns = scan.nextInt();

		int matrix1[][] = new int[rows][columns];
		System.out.println("Enter Matrix Data : ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix1[i][j] = scan.nextInt();
			}
		}
		int tranposeMatrix[][] = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tranposeMatrix[j][i] = matrix1[i][j];
			}
		}
		System.out.println("Matrix");
		for (int[] is : matrix1) {
			System.out.println(Arrays.toString(is));
		}
		
		System.out.println("Matrix Traspose");
		for (int[] is : tranposeMatrix) {
			System.out.println(Arrays.toString(is));
		}
	}

}
