package com.javaiqs;

import java.util.Comparator;
import java.util.PriorityQueue;

class Employee {
	String name;
	int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}

class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
//		return o1.salary-o2.salary; //Lowest
		return o2.salary - o1.salary; // highest
	}

}

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}

}

public class PriorityQueueConcept {

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		priorityQueue.add(11);
		priorityQueue.add(20);
		priorityQueue.add(10);
		priorityQueue.add(17);
		priorityQueue.add(101);
		priorityQueue.add(01);
		priorityQueue.add(2);
//		priorityQueue.add(12);
//		priorityQueue.add(1);
//		priorityQueue.add(3);
//		priorityQueue.add(7);
//		priorityQueue.add(5);
//		priorityQueue.add(9); 
		
		
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.poll());
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.remove());
		System.out.println(priorityQueue);

		EmployeeComparator comparator = new EmployeeComparator();
		PriorityQueue<Employee> queue = new PriorityQueue<>(comparator);
		queue.add(new Employee("nayeem", 10000));
		queue.add(new Employee("John", 14000));
		queue.add(new Employee("mike", 1000));
		queue.add(new Employee("kite", 250000));
		System.out.println(queue);
		System.out.println(queue.poll());
		
		StringComparator stringComparator = new StringComparator();
		PriorityQueue<String> priorityQueue2 = new PriorityQueue<String>(stringComparator);
		
		priorityQueue2.add("nayeem");
		System.out.println(priorityQueue2);
		priorityQueue2.add("nayfdfadfsfsdfsdsfdfdsfaseem");
		System.out.println(priorityQueue2);
		priorityQueue2.add("12345667888");
		System.out.println(priorityQueue2);
		priorityQueue2.add("d");
		System.out.println(priorityQueue2);
		priorityQueue2.add("ssss");
		System.out.println(priorityQueue2);
		priorityQueue2.add("adasdas");
		System.out.println(priorityQueue2);
		System.out.println(priorityQueue2.poll());
	}

}
