package com.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {
	
	private String name;
	private int age;
	

}
