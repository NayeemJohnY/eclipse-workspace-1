package com.pojo;

public class TestUser {

	public static void main(String[] args) {

		User u1 = User.builder().name("John").age(27).build();
		System.out.println(u1);
		User u2 = User.builder().name("Ava").build();
		System.out.println(u2);
		User u3 = User.builder().build();
		System.out.println(u3);
	}

}
