package net.sady.selfstudy;

public class Test {
	
	public static boolean posNeg(int a, int b, boolean negative) {
		if(negative && a == -Math.abs(a) && b == -Math.abs(b)){
		    return true;
		} else if( !negative && ( a == Math.abs(a) && b == -Math.abs(b)) 
		      || (a == -Math.abs(a) && b == Math.abs(b)) ) {
		    return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		System.out.println(Test.posNeg(-4,5, true));
		String str ="jgds";
		//str.length(0,3);
		System.out.println(str.substring(0, 3));
		
		char ch [] = str.toCharArray();
		String s = new String(ch);
		System.out.println(s);   
		char temp =ch[0];
		   ch[0] = ch[ch.length -1];
		   ch[ch.length -1] = temp;
		   //return ch.toString();
		
	}

}
