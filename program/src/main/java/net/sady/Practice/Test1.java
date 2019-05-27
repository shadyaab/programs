package net.sady.Practice;

import java.util.HashMap;
import java.util.Map;

class Employee{
	int id;
	String name;
	int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			if(this.id == ((Employee) obj).getId()) {
				return true;
			}
		}
		return false;
	}
	/*
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return id + name + age; }
	 */
}

class Test1  {
	public static void main(String[] args) {
		
		Employee emp1 = new Employee(3, "sady1", 26);
		Employee emp2 = new Employee(3, "sady2", 27);
		System.out.println(emp1.hashCode() + " " + emp2.hashCode());
		emp1.setAge(28);
		System.out.println(emp1.hashCode() + " " + emp2.hashCode());
		//System.out.println(emp1.hashCode() + " " + emp2.hashCode());
		//System.out.println(emp1.hashCode() + " " + emp2.hashCode());
		System.out.println(emp1.equals(emp2));
		
		
		
		
		
		
		
		/*
		 * Employee emp3 = new Employee(5, "sady3", 28); System.out.println(emp1 + " " +
		 * emp2 + " " + emp3);
		 * 
		 * Map<Employee, Employee> map = new HashMap<>(); map.put(emp1, emp1);
		 * map.put(emp2, emp2); map.put(emp3, emp3);
		 * 
		 * System.out.println(map.get(emp1)); emp1.setName("raj"); map.put(emp1, emp1);
		 * System.out.println(emp1 + " " + emp2 + " " + emp3);
		 * 
		 * map .entrySet() .stream() .map(d -> d.getValue().getName())
		 * .forEach(System.out::println);
		 */
		
	}


}
