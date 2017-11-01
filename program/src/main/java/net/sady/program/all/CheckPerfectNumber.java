package net.sady.program.all;

public class CheckPerfectNumber {
	public boolean isPerfectNumber(int num) {
		
		int sum = 0;
		int i = 0;
		while(++i < num) {
			if(num % i == 0) {
				sum += i;
			}
		}
		return num == sum;
	}
	
	public static void main(String[] args) {
		CheckPerfectNumber obj = new CheckPerfectNumber();
		int num = 28;
		System.out.println(num + " is Perfect number : " + obj.isPerfectNumber(num));
	}

}
