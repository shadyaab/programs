package net.sady.selfstudy;

class A {
	private int x;
	
	A(int x){
		this.x=x;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof A && this.x == ((A)obj).x){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		return x*17;
	}

}
 
class HashCodeDemo {
	public static void main(String[] args) {
		A a = new A(5);
		A b = new A(5);
		System.out.println(a == b);
		//System.out.println(a.equals(b));
		 
		
		String str1= "sady";
		 String str2= "sady";
		System.out.println(str1 == str2);
	}
}
