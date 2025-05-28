package com.practise;

import java.util.Arrays;

public class CheckAnagramStrings {

	public static void isAnagram(String s1, String s2) {
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		if (s1.length() == s2.length()) {
			char[] c1 = s1.toLowerCase().toCharArray();
			char[] c2 = s2.toLowerCase().toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			System.out.println("Is String Anagram : " + Arrays.equals(c1, c2));
		} else {
			System.out.println("String are not having same length");
		}
	}

	public static void main(String[] args) {
		isAnagram("Nayeem", "John");
		isAnagram("listen", "SILENT");
		isAnagram("BAT", "TaB");
		isAnagram("BAT", "TABT");
		isAnagram("l i  sten ", "SI  LE		N  T");
		
	}

}
