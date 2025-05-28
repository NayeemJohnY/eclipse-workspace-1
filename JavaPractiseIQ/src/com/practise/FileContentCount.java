package com.practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileContentCount {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\NayeemJohnY\\Downloads\\PIL.txt";

		File file = new File(filePath);
		int lineCounter = 0;
		int wordCounter = 0;
		int charCounter = 0;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lineCounter++;
				String[] wordArray = line.trim().split(" ");
				
				for (String word : wordArray) {
					wordCounter++;
					charCounter += word.length();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total Number Of Lines "+ lineCounter);
		System.out.println("Total Number Of Words "+ wordCounter);
		System.out.println("Total Number Of Characters "+ charCounter);		
	}

}
