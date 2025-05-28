package com.pojo;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Product {
	
	// Plain Old Java Object
	private String name;
	private int price;
	private String color;
	private String [] sellerNames;

	@Beanc(properties = "name, price, color, sellerNames")
	public Product(String name, int price, String color, String[] sellerArray) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
		this.sellerNames = sellerArray;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", color=" + color + ", sellerNames="
				+ Arrays.toString(sellerNames) + "]";
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String[] getSellerNames() {
		return sellerNames;
	}
	public void setSellerNames(String[] sellerNames) {
		this.sellerNames = sellerNames;
	}
	

}
