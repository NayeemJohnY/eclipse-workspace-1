package com.practise;

public class FindAllLeaders {
	
	
	public static void findLeaders(int[] array) {
//		int leaders[] = new int[array.length];
//		int j = 0;
//		for(int i = 0 ; i < array.length-1 ; i ++) {
//			if(array[i] > array[i+1]) {
//				leaders[j]= array[i];
//				j++;
//			}
//		}
//		for(int i = 0 ; i < leaders.length-1 ; i ++) {
//			System.out.println(leaders[i]);
//		}
		
		if (array.length == 0) {
			System.out.println("Empty Array");
		} else if (array.length == 1) {
			System.out.println(array[0]);
		} else {
			int leader = array[array.length-1];
			System.out.println(leader);
			for(int i = array.length-2 ; i >= 0 ; i --) {
				if(array[i]>leader) {
					leader = array[i];
					System.out.println(leader);
				}
			}
		}
	}

	public static void main(String[] args) {

		findLeaders(new int []{10,2, 30, 3, 14, 7, 3, 8, 2});
		findLeaders(new int []{});
		findLeaders(new int []{2});
		findLeaders(new int []{9, 9, 0, 0});
		
	}

}
