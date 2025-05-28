package com.practise.filehandle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateFile {

	public static void main(String[] args) {
		// Method 1
		String path = "C:\\Users\\NayeemJohnJohnY\\Downloads\\sample.text";
		File file = new File(path);
		boolean fileCreated = false;
		try {
			fileCreated = file.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileCreated);

		// Method 2
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name wtih Path ::");
		String filename = sc.nextLine();
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
			System.out.println("Enter File Name wtih contents ::");
			String content = sc.nextLine();
			fileOutputStream.write(content.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Method 3 -java nio
		Path filePath = Paths.get("C:\\Users\\NayeemJohnJohnY\\Downloads\\sample3.text");
		try {
			Path newPath = Files.createFile(filePath);
			System.out.println("new Path File " + newPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
