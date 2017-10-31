package net.sady.program.all;

public class ReverseNumberUsingRecursion {
	
	Integer resultant = 0;
	
	public Integer reverse(int num){
		
		if(num <= 0){
			return num;
		} else{
			num = num/10;
			resultant = (resultant * 10) + (num % 10) ;
			
		}
		
		return  null;
	}
	
	public static void main(String[] args) {
		ReverseNumberUsingRecursion obj = new ReverseNumberUsingRecursion();
		System.out.println(obj.reverse(12345));
	}
}
