package net.sady.java8.newinterface;

interface A{
	void test(String str);
	
	default boolean testDefault(String str){
		return str.length() > 0;
	}
	
	static void testStatic(String str){
		System.out.println(str);
	}
}

public class InterfaceInPractice implements A{

	public static void main(String[] args) {
		A.testStatic("Hello");
		A a = new InterfaceInPractice();
		a.testDefault("World");
	}
	
	@Override
	public void test(String str) {
		// TODO Auto-generated method stub
		
	}
}


