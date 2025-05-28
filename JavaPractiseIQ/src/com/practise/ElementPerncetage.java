package com.practise;

import java.text.DecimalFormat;

public class ElementPerncetage {
	
	public static void findPercentage(String str) {
		int upperCaseCount = 0;
		int lowerCaseCount = 0;
		int digitCount = 0;
		int specialCharCount = 0;
		
		for(char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				upperCaseCount++;
			} else if (Character.isLowerCase(c)) {
				lowerCaseCount++;
			} else if (Character.isDigit(c)) {
				digitCount++;
			} else {
				specialCharCount++;
			}
		}
		DecimalFormat format = new DecimalFormat("##.##");
		System.out.println("Upper case % => "+ format.format(((double)upperCaseCount*100/str.length())));
		System.out.println("Lower case % => "+ format.format((double)lowerCaseCount*100/str.length()));
		System.out.println("Digit %	=> "+  format.format(((double)digitCount*100/str.length())));
		System.out.println("Special case % => "+  format.format(((double)specialCharCount*100/str.length())));
		System.out.println("Total % => "+  format.format(((double)(upperCaseCount+lowerCaseCount+digitCount+specialCharCount)*100/str.length())));
		System.out.println("-----------------------------------------");
	}

	public static void main(String[] args) {
		findPercentage("Nayeem John 90");
		findPercentage("Groups ssqaa $$$$");
		findPercentage("1");
		findPercentage("a");
		findPercentage("Q");
		findPercentage("Q$");
		findPercentage("Q$a");
		findPercentage("a!A5");

	}

}
