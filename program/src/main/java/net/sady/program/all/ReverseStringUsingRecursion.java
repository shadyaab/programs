package net.sady.program.all;

 class ReverseStringUsingRecursion {

	String reverse = "";
	
	public String reverseString(String str) {
		if(str.length() == 1){
			return str;
		} else{
			reverse += reverseString(str.substring(1)) + str.charAt(0);
		}
		return reverse;
	}

	public static void main(String[] args) {
		ReverseStringUsingRecursion obj = new ReverseStringUsingRecursion();
		System.out.println(obj.reverseString("Shadyaab"));
	}
	
 }
