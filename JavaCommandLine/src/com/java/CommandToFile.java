package com.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CommandToFile {
	
	
	// Will work for the Error Streams means that the command prompt log level is error
	// java -version
	public static void saveCommandErrorOutputToFile(String command) {
		try {
			FileOutputStream fileOutputStream  = new FileOutputStream("outputError.txt");
			Process process = Runtime.getRuntime().exec(command);
			Reader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			int s = 0;
			while ((s = reader.read()) != -1) {
				fileOutputStream.write(s);
			}
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Will work for the Input Streams means that the command prompt log level is not error
	//ping google.com
	public static void saveCommandOutputToFile(String command) {
		try {
			FileOutputStream fileOutputStream  = new FileOutputStream("output.txt");
			Process process = Runtime.getRuntime().exec(command);
			Reader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			int s = 0;
			while ((s = reader.read()) != -1) {
				fileOutputStream.write(s);
			}
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String command = "java -version";
		// Error file
		saveCommandErrorOutputToFile(command);
		// Output file
		saveCommandOutputToFile("ping google.com");
		
	}
}
