package com.practise;

import java.io.IOException;

public class AppRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runTime = Runtime.getRuntime();
		
		
		try {
			// 1. Open a Notepad
//			Process pr = runTime.exec("notepad.exe");
			
			// 2. open a file with notepad
//			Process pr = runTime.exec("notepad.exe C:\\Users\\NayeemJohnY\\Downloads\\import_appgetway.json");
			
			// 3. Launching google and visit website
			String [] commandArray = new String[] {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "https://udemy.com"};
			Process pr = runTime.exec(commandArray);
			
			Thread.sleep(4000);
			
			pr.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
