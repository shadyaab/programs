package net.sady.selfstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
	private int id;
	private String name;
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString(){
		return id + " " + name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class NameComparator implements Comparator<Person>{
	public int compare(Person p1, Person p2){
		return p1.getName().compareTo(p2.getName());
	}
}
class IdComparator implements Comparator<Person>{
	public int compare(Person p1, Person p2){
		if(p1.getId() == p2.getId()){
			return 0;
		}
		else{
			return p1.getId() > p2.getId() ? 1 : -1;
		}
	}
}

class NameAndIdComparator implements Comparator<Person>{
	@Override
	public int compare(Person p1, Person p2){
		int nameComparator = p1.getName().compareTo(p2.getName());
		int idComparator = p1.getId() == p2.getId() ? 0 : (p1.getId() > p2.getId() ? 1 : -1);
		
		if(nameComparator == 0){
			return idComparator;
		} else {
			return nameComparator;
		}
	}
}

public class ComparatorDemo {
	public static void main(String[] args) {
		Person p1 = new Person(1, "Shadyaab");
		Person p2 = new Person(4, "Ronit");
		Person p3 = new Person(2, "Vatsa");
		Person p4 = new Person(3, "Sirohi");
		Person p5 = new Person(3, "Shadyaab");
		
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		System.out.println(list);
		NameComparator nc = new NameComparator();
		IdComparator ic = new IdComparator();
		Collections.sort(list, nc);
		System.out.println(list);
		Collections.sort(list, ic);
		System.out.println(list);
		
		NameAndIdComparator nic = new NameAndIdComparator();
		Collections.sort(list, nic);
		System.out.println(list);
	}
}
