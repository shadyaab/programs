package net.sady.hackerrank.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int empId;
	private String name;
	private int experience;

	public Employee(int empId, String name, int experience) {
		this.empId = empId;
		this.name = name;
		this.experience = experience;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", experience=" + experience + "]";
	}
}


public class SerializationDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Employee emp = new Employee(1, "sady", 3);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
		oos.writeObject(emp);
		oos.close();
		
		System.out.println("Object is serialized successfully");
		
		emp = null;
		
		/*******************Deserialization****************************************/
		
		//ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))){
			emp = (Employee)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Object is deserialized successfully");
		System.out.println(emp);
	}

}
