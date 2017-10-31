package net.sady.program.all;

public class ReverseNumber {
	
	public Integer reverse(int num){
		Integer resultant = 0;
		while(num > 0){
			resultant = (resultant * 10) + (num % 10) ;
			num = num/10;
		}
		return resultant;
	}
	
	public static void main(String[] args) {
		ReverseNumber obj = new ReverseNumber();
		System.out.println(obj.reverse(12345));
	}

}
