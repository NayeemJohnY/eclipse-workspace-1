package com.practise.filehandle;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileRead {

	public void openFileUsingDesktop(String path) {

		File file = new File(path);
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				if (file.exists()) {
					desktop.open(file);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Desktop not supported");
		}

	}

	public void readFileUsingFileInputStream(String path) {
		File file = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int i = 0;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readFileUsingBufferedReader(String path) {
		File file = new File(path);
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			int i = 0;
			while ((i = bufferedReader.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readFileUsingFileReader(String path) {
		File file = new File(path);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			int i = 0;
			while ((i = fileReader.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readFileUsingScanner(String path) {
		System.out.println("=============================== readFileUsingScanner =============================");
		File file = new File(path);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	public void readFileUsingNIO(String path) {
		System.out.println("=============================== readFileUsingNIO =============================");
		try {
			List<String> contentList = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			contentList.stream().forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\NayeemJohnJohnY\\Downloads\\document.txt";
		// TODO Auto-generated method stub
		FileRead fileRead = new FileRead();
		fileRead.openFileUsingDesktop(path);
		fileRead.readFileUsingFileInputStream(path);
		fileRead.readFileUsingBufferedReader(path);
		fileRead.readFileUsingFileReader(path);
		fileRead.readFileUsingScanner(path);
		fileRead.readFileUsingNIO(path);

	}

}
