package com.pojo;

public class CustomerTest {
	
	public static void main(String[] args) {
		Customer customer = new Customer("john", 27, "Chennai", true);
		System.out.println(customer);
		customer.setActive(false);
		System.out.println(customer.getName() + " "+ customer.isActive());
	}

}
