package com.springboot.telusko2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

	@Id
	private int aid;
	private String name;
	private String tech;

	public int getAid() {
		return aid;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", name=" + name + ", tech=" + tech + "]";
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

}
