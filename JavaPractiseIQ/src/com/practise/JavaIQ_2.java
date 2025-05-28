package com.practise;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaIQ_2 {

	public void checkSubstringInString() {
		String str = "Conceptual Group";
		System.out.println(str.matches("(.*)Group(.*)")); // Using Reg Exp (.*)subString(.*)
		System.out.println(str.contains("Group"));
		System.out.println(str.indexOf("Group") != -1);
	}

	public void findCountOfWordsInCaptializedString() {
		String str = " inCheckStringFoundLa";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') { // 1)use charAt and 'A' and 'Z"
				// 2) or ASCII 65='A' and 90='Z'
				count++;
			}
		}
		System.out.println(count);
		// 3) Character UpperCase
		count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				count++;
			}
		}
		System.out.println(count);
		// 4) Streams
		System.out.println(str.chars().filter(e -> Character.isUpperCase(e)).count());
		// 5) Regex
		count = 0;
		Matcher m = Pattern.compile("[A-Z]+").matcher(str);
		while (m.find()) {
			count += m.group().length();

		}
		System.out.println(count);
		// But considering "in" beginning
		if (Character.isLowerCase(str.charAt(0))) {
			count++;
		}
		// if contains space at begin
		if (Character.isLowerCase(str.trim().charAt(0))) {
			count++;
		}
		System.out.println(count);
	}

	public void stringJoinerConcept() {
		// String joiner in JDK 8 , It is a class
		StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
		stringJoiner.add("Nayeem").add("27").add("SDET");
		System.out.println(stringJoiner);
	}

	public void vowelsCountInString() {
		String str = "Hello Vowel Dare";
		int count = 0;
		// Method 1 - Simple For loop and if block
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I'
					|| str.charAt(i) == 'O' || str.charAt(i) == 'U') {
				count++;
			}
		}
		System.out.println(count);

		// Method 2 - Reg exp
		count = str.length() - str.replaceAll("[AEIOUaeiou]", "").length();
		System.out.println(count);

		// Method 3 - Java 8 Streams using predicate with if condition
		IntPredicate vowel = new IntPredicate() {

			@Override
			public boolean test(int value) {
				// TODO Auto-generated method stub
				return value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u' || value == 'A'
						|| value == 'E' || value == 'I' || value == 'O' || value == 'U';
			}
		};

		System.out.println(str.chars().filter(vowel).count());
		// Using Guava library
	}

	public void findlengthWithoutMethod() {
		String str = "Hello Nayeem";
		System.out.println(str.toCharArray().length); // 1 char array length
		System.out.println(str.lastIndexOf("")); // last index of nothing
		Matcher m = Pattern.compile("$").matcher(str); // Regex , find and end
		m.find();
		System.out.println(m.end());
		System.out.println(str.split("").length);

		int i = 0; // using try catch and while
		try {
			while (true) {
				str.charAt(i);
				i++;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(i);
		}
		try { // using bytes
			System.out.println(str.getBytes("UTF-16BE").length / 2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findDuplicateCharactersInString() {
		String str = "das dasss bc";
		if (str == null) {
			System.out.println("String is Null");
		} else if (str.trim() == "") {
			System.out.println("String is Empty");
		} else if (str.length() == 1) {
			System.out.println("String length is 1, So can't contain duplicate char");
		} else {
//			char[] charArray = new char[str.length()];
//			int k = 0;
//			for (int i = 0; i < str.length(); i++) {
//				for (int j = i + 1; j < str.length(); j++) {
//					if (str.charAt(i) == str.charAt(j)) {
//						charArray[k] = str.charAt(i);
//						k++;
//					}
//				}
//			}
//			System.out.println(String.valueOf(charArray));
			Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
			for (char ch : str.replace(" ", "").toCharArray()) {
				if (charCountMap.containsKey(ch)) {
					charCountMap.put(ch, charCountMap.get(ch) + 1);
				} else {
					charCountMap.put(ch, 1);
				}
			}
			for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
				if (entry.getValue() > 1) {
					System.out.println(entry.getKey());
				}
			}
		}

	}

	// Count of occurrences of a character in String
	public void countOccurenceofCharacters() {
		String s1 = "Hello Nayeem";
		// 1. Char Array and loops
		char searchChar = 'e';
		int charCount = 0;
		for (char ch : s1.toCharArray()) {
			if (ch == searchChar) {
				charCount++;
			}
		}
		System.out.println(charCount);

		// 2. String length
		charCount = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == searchChar) {
				charCount++;
			}
		}
		System.out.println(charCount);

		// 3. Streams
		long countChar = s1.chars().mapToObj(e -> String.valueOf((char) e)).filter(e -> e.equals("o")).count();
		System.out.println(countChar);

		System.out.println(s1.chars().filter(e -> (char) e == 'o').count());
		// 4. StringUtils from lang3 Apache common library
//		StringUtils.countMathces(s1, ch);

	}

	public void stringObjects() {
		// Heap , Stack, String Constant pool
		// String literals create objects in SCP
		// String Objects create objects in both SCP and Heap (in SCP if object not
		// exists)
		// In Stack reference will be stored
		String s1 = "Hello World";
		String s2 = "Hello World";
		String s3 = s2; // Object Count 1
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		String n1 = new String("Hello World"); // Object Count 2 ( 1 Heap + 1 SCP) In Heap New object created with the
												// same object in SCP
		// Total Objects created is 3
		System.out.println(n1 == s3);

	}

	public static void main(String[] args) {
		JavaIQ_2 javaIQ_2 = new JavaIQ_2();
		javaIQ_2.stringObjects();
		javaIQ_2.countOccurenceofCharacters();
		javaIQ_2.findDuplicateCharactersInString();
		javaIQ_2.findlengthWithoutMethod();
		javaIQ_2.vowelsCountInString();
		javaIQ_2.stringJoinerConcept();
		javaIQ_2.findCountOfWordsInCaptializedString();
		javaIQ_2.checkSubstringInString();
	}

}
