package com.practise.oop;

public class Student {

	private String name;
	private String rollNum;
	private int marks;

	public Student(String name, String rollNum, int marks) {
		this.name = name;
		this.rollNum = rollNum;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rollNum == null) ? 0 : rollNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNum == null) {
			if (other.rollNum != null)
				return false;
		} else if (!rollNum.equals(other.rollNum))
			return false;
		return true;
	}

	public String getRollNum() {
		return rollNum;
	}
	
	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNum=" + rollNum + ", marks=" + marks + "]";
	}

}
