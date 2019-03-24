package net.sady.hackerrank.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Emp implements Serializable {

	private static final long serialVersionUID = 1L;

	private int empId;
	private String name;
	private int experience;
	
	private String password;

	public Emp(int empId, String name, int experience, String password) {
		this.empId = empId;
		this.name = name;
		this.experience = experience;
		this.password = password;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		
		String encyptPass = "123" + this.password;
		
		oos.writeObject(encyptPass);
		
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		
		String encyptPass = (String)ois.readObject();
		
		this.password = encyptPass.substring(3);
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + ", experience=" + experience + ", password=" + password + "]";
	}
}


public class CustomSerializationDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Emp emp = new Emp(1, "sady", 3, "sady");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
		oos.writeObject(emp);
		oos.close();
		
		System.out.println("Object is serialized successfully");
		
		emp = null;
		/*******************Deserialization****************************************/
		
		//ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))){
			emp = (Emp)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Object is deserialized successfully");
		System.out.println(emp);
	}

}
