package net.sady.Practice;

public class Test2 {

	private static int test() {
		try {
			System.out.println("try");
			//int x = 5/0;
			return 1;
		} catch (Exception e) {
			System.out.println("Exception");
			return 2;
		} finally {
			System.out.println("finally");
			return 3;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	
	
}
