package net.sady.program.array_string;

public class Anagram {
	
	public static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		int[] checkRepeat = new int[256];
		for(int i=0; i<str1.length(); i++){
			int val = str1.charAt(i);
			checkRepeat[val]++;
		}
		for(int i=0; i<str2.length(); i++){
			int val = str2.charAt(i);
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "dbca";
		//System.out.println(str1 + " and " + str2 + " is anagram : " + isAnagram(str1, str2));

		
		int x = 100;
        int y =  5 ^ x;
        System.out.println(y);
        int z;
        z = x > y ? x : y;
        System.out.print(z);
	}
}
