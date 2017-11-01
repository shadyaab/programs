package net.sady.program.all;

import java.util.Arrays;

class NewArrayList {

	private Object [] myArray;
	private Integer size = 0;
	
	public NewArrayList() {
		myArray = new Object[8];
	}
	
	public NewArrayList(Integer size) {
		myArray = new Object[size];
	}
	
	public void add(Object obj) {
		if(myArray.length - size <= 4){
			increaseArray();
		}
		myArray[size++] = obj;
	}

	public Object get(Integer index) {
		if(index < size) {
			return myArray[index];
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public Object remove(Integer index) {
		if(index < size) {
			Object obj = myArray[index];
			int i;
			for(i = index ; i < size-1; i++) {
				myArray[index] = myArray[index+1];
			}
			myArray[i] = null;
			size--;
			return obj;
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public Integer size() {
		return size;
	}
	public void increaseArray() {
		myArray = Arrays.copyOf(myArray, myArray.length*2);
		System.out.println("\nArray Size has been increse to " + myArray.length);
	}

}

public class MyArrayList {
	public static void main(String[] args) {
		NewArrayList arrayList = new NewArrayList();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		
		display(arrayList);
		
		arrayList.remove(2);
		arrayList.add(5);
		arrayList.add(6);
		
		display(arrayList);
		System.out.println(arrayList.size());
		
	}
	public static void display(NewArrayList arrayList){
		for(int i=0; i< arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println("");
	}
	
}







