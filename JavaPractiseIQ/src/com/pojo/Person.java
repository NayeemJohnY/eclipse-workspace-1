package com.pojo;

import lombok.Builder;
import lombok.ToString;

@ToString //class level
public class Person {
	
	private String name;
	private int age;
	private String city;
	
//	@Builder // Customer level
//	public Person(String name, int age) {
//		this.age = age;
//		this.name = name;
//	}
	
	public Person(String name, int age, String city) {
	this.age = age;
	this.name = name;
	this.city = city;
}
	
	@Builder // Method level
	public static Person createInstance(String name, int age) {
		return new Person(name, age, "London");
	}

	public static void main(String[] args) {
		Person p1 = Person.builder().name("Aqa").age(20).build();
		System.out.println(p1);
		p1.city = "Chennai";
		System.out.println(p1);
	}

}
