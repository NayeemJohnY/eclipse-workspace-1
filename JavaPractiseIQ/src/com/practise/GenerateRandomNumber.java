package com.practise;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumber {

	public static void main(String[] args) {
	
		Random  random =  new Random();
		for( int  i = 0; i < 5 ; i++) {
			System.out.println("Random Integer Number: "+ random.nextInt());
			System.out.println("Random Double Number: "+ random.nextDouble());
			System.out.println("Random Float Number: "+ random.nextFloat());
			System.out.println("Random Boolean  :"+ random.nextBoolean());
		}
		System.out.println("=================================================");
		
		for( int  i = 0; i < 5 ; i++) { // 2. only Double
			System.out.println("Random Math "+ Math.random());
		}
		System.out.println("=================================================");
		
		for( int  i = 0; i < 5 ; i++) {
			System.out.println("Random Integer Number: "+ ThreadLocalRandom.current().nextInt());
			System.out.println("Random Double Number: "+ ThreadLocalRandom.current().nextDouble());
			System.out.println("Random Float Number: "+ ThreadLocalRandom.current().nextFloat());
			System.out.println("Random Boolean  :"+ ThreadLocalRandom.current().nextBoolean());
			
		}
		System.out.println("=================================================");
		
		for( int  i = 0; i < 5 ; i++) {
			System.out.println("Random Integer Number Bound : "+ random.nextInt(20));
			System.out.println("Random Math Number Bound : "+	(int)(Math.random() * 20));
			System.out.println("Random Thread local Number Bound : "+	ThreadLocalRandom.current().nextInt(0, 20));
		}
	}

}
