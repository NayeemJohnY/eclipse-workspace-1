package com.practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Collections;
import java.util.HashMap;

public class MaxWordCount {

	public static void main(String[] args) {

		String filePath = "C:\\Users\\NayeemJohnY\\Downloads\\PIL.txt";

		File file = new File(filePath);
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		try {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					String[] wordArray = line.toLowerCase().split(" ");
					for (String word : wordArray) {
						if (!word.isBlank()) {
							if (wordMap.containsKey(word)) {
								wordMap.put(word, wordMap.get(word) + 1);
							} else {
								wordMap.put(word, 1);
							}
						}

					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		wordMap.forEach((k, v) -> System.out.println(k + " : " + v));

		HashMap<String, Integer> maxWordMap = new HashMap<String, Integer>();

		wordMap.entrySet().stream().filter(entry -> entry.getValue() == Collections.max(wordMap.values()))
				.forEach(e -> maxWordMap.put(e.getKey(), e.getValue()));
		
		System.out.println("Max Map \n"+ maxWordMap);
	}

}
