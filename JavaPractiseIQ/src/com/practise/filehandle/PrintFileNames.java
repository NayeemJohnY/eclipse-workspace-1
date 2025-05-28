package com.practise.filehandle;

import java.io.File;
import java.util.Arrays;

public class PrintFileNames {

	public static void main(String[] args) {
		String path = "C:\\Users\\NayeemJohnJohnY\\Downloads";
		File file = new File(path);
		
		File[] fileUnderPath = file.listFiles();
		Arrays.sort(fileUnderPath);
		for (File e : fileUnderPath) {
			if(e.isFile()) {
				System.out.println("File Name :: "+ e.getName());
			} else if (e.isDirectory()) {
				System.out.println("Directory :: "+e.getName());
			}else {
				System.out.println("Unknow");
			}
		}
	}

}
