package net.sady.selfstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int compareTo(Employee e){
		return name.compareTo(e.name);
	}
	
	public String toString(){
		return id + " " + name;
	}
}

public class ComparableDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Shadyaab");
		Employee e2 = new Employee(4, "Ronit");
		Employee e3 = new Employee(2, "Vatsa");
		Employee e4 = new Employee(3, "Sirohi");
		
		List<String> strList = new ArrayList<String>();
		strList.add("Shadyaab");
		strList.add("Ronit");
		strList.add("Vatsa");
		strList.add("Sirohi");
		Collections.sort(strList);
		System.out.println(strList);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		Collections.sort(list);
		System.out.println(list);
	}
}
