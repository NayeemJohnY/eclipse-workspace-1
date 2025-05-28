package com.practise.filehandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyConcept {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\NayeemJohnJohnY\\Downloads\\Inchara's Resume (2).pdf");
		File opFile = new File("C:\\Users\\NayeemJohnJohnY\\Downloads\\Updated_Resume_Irch.pdf");

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		try {
			fileInputStream = new FileInputStream(file);
			fileOutputStream = new FileOutputStream(opFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(fileInputStream.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;
		try {
			while ((i = fileInputStream.read()) != -1) {
				fileOutputStream.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
