package com.practise;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIQ_3 {

	public void findDuplicateElementsinArray() {
		// 1. brute force - two for loops
		// 2. HashSet
		// 3. HashMap - K-V -count -time of repeated
		// 4. Using Streams with frequency, filtering, groupBy
		String[] providers = { "AWS", "GCP", "Azure", "AWS", "GCP", "Ali Baba" };

		// 1 . Brute Force
		String[] duplicate = new String[providers.length / 2];
		int k = 0;
		System.out.println("Brute Force");
		for (int i = 0; i < providers.length; i++) {
			for (int j = i + 1; j < providers.length; j++) {
				if (providers[i].equals(providers[j])) {
					duplicate[k] = providers[i];
					k++;
				}
			}
		}
		System.out.println(Arrays.toString(duplicate));
		// 2. HashSet
		HashSet<String> duplicateElements = new HashSet<>();
		for (int i = 0; i < providers.length; i++) {
			if (!duplicateElements.add(providers[i])) {
				System.out.println(providers[i]);
			}
		}
		// 3. HashMap
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < providers.length; i++) {
			if (map.containsKey(providers[i])) {
				System.out.println(providers[i]);
			} else {
				map.put(providers[i], 1);
			}
		}
		// 4. Streams - filter
		HashSet<String> hashSet = new HashSet<>();
		List<String> dupList = Arrays.asList(providers).stream().filter(e -> !hashSet.add(e))
				.collect(Collectors.toList());
		System.out.println(dupList);

		// 5. Streams - Grouping Function identity Collections counting
		dupList = Arrays.asList(providers).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(dupList);

		// 6. Steams using frequency
		Set<String> dupSet = Arrays.asList(providers).stream()
				.filter(e -> Collections.frequency(Arrays.asList(providers), e) > 1).collect(Collectors.toSet());
		System.out.println(dupSet);
	}

	/**
	 * Why password should be stored in char [] instead of String Java recommends
	 * char [] Heap, Stack, SCP, inside SCP heap password object is not deleted
	 * hacker memory dump or hear dump, trace password, Before the garbage collector
	 * zero the string after usage To use String , encrypted String Server Logs ,
	 * char object printed
	 */

	/**
	 * AutoBots and Language Translator
	 */
	static {
		try {
			Field value = String.class.getDeclaredField("value");
			value.setAccessible(true);
			value.set("Hello Nayeem", value.get("நயீமை வரவேற்கிறோம்"));
			value.set("How are you", value.get("Como você está?"));
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findMissingElementInArray() {
		int[] num = { 1, 2, 4, 5, 6 };
		// total = n(n+1)/2
		int actualSum = 0;
		for (int n : num) {
			actualSum += n;
		}
		int expSum = num[num.length - 1] * (num[num.length - 1] + 1) / 2;
		System.out.println("Missing number ::" + (expSum - actualSum));
	}

	public void averageOfArray() {
		int num[] = { 10, 20, 45, 67 };
		int total = 0;
		// 1. Method 1 - Loop
		for (int a : num) {
			total += a;
		}
		System.out.println("Average :: " + total / num.length);

		// 2. Method 2 - Streams
		double avg = Arrays.stream(num).average().getAsDouble();
		System.out.println(avg);

		// 3. Method 3 - Google Guava
		// DoubleMath.mean(num)
	}

	public void joinTwoArrays() {
		String[] names = { "Nayeem", "John", "Vimal" };
		String[] roles = { "SDET", "QA", "FSD" };

		// 1. Java 8 => Streams, concat streams and size
		Stream<String> steamOfNames = Arrays.stream(names);
		Stream<String> steamOfRoles = Arrays.stream(roles);

		String[] employee = Stream.concat(steamOfNames, steamOfRoles).toArray(size -> new String[size]);
		for (String s : employee) {
			System.out.println(s);
		}

		// 2. Google Guava ObjectArrays.concat(array1, array2, String.class) or
		// primitive types Ints
	}

	// Print 1 to 100 without using loop, Steams and recursion
	public void printNumberWithoutLoop() {
		// 1. Arrays fill
		Object num[] = new Object[100];
		Arrays.fill(num, new Object() {
			int count = 0;

			@Override
			public String toString() {
				return Integer.toString(++count);
			}
		});
		System.out.println(Arrays.toString(num));

		// 2. Bit Set
		String set = new BitSet() {
			{
				set(1, 101);
			}
		}.toString();
		System.out.println(set);
	}

	public static void main(String[] args) throws MalformedURLException {
		JavaIQ_3 iq_3 = new JavaIQ_3();
		iq_3.printNumberWithoutLoop();
		iq_3.joinTwoArrays();
		iq_3.averageOfArray();
		iq_3.findMissingElementInArray();
		// Comparing website URL with IP address
		System.out.println(new URL("https://www.uptrends.com").equals(new URL("https://195.201.9.51")));
		// Execute the Comments in Java
		// '\\u000d means new line Carige return
		// Hello \u000d
		System.out.println("Nayeem Here");
		System.out.println("Hello Nayeem");
		System.out.println("How are you");
		int i = (byte) +(char) -(int) +(long) -1;
		// long(-1) => -int (-1) => +1 =>char 1=>byte 1
		System.out.println(i);
		System.out.println((long) 'A');
		System.out.println((byte) -'a');

		/**
		 * "Hello" can't '"hello"' should write \"hello \" -\" to escape \hello can't to
		 * escape \\ /"Hello"/ '/'Hello'/' "Java" is a programming "language"
		 */
		System.out.println("\"hello\"");
		System.out.println("\\hello");
		System.out.println("/\"Hello\"/");
		System.out.println("'/'Hello'/'");
		System.out.println("\"Java\" is a programming \"language\"");

		iq_3.findDuplicateElementsinArray();
	}

}
