package net.sady.selfstudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student{
	private String name;
	private Integer roll;
	
	Student(String name, Integer roll){
		this.name = name;
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	
	public String toString(){
		return roll + " " + name;
	}
}

public class IteratorDemo {
	public static void main(String[] args) {
		Student s1 = new Student("raj", 250);
		Student s2 = new Student("ram", 253);
		Student s3 = new Student("rahul", 251);
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Iterator<Student> itr = list.iterator();
		while(itr.hasNext()){
			Student std = itr.next();
			System.out.println(std.getName());
		}
		
		//Converting list into array
		Object[] obj = list.toArray();
		
		// It tell if you change in list it will reflect in the array
		list.get(1).setName("Shadyaab");
		for(Object o : obj){
			Student s = (Student)o;
			System.out.println(s.getRoll() + " " + s.getName() );
		}
		
	}
}
