package net.sady.program.array_string;

public class UniqueCharacter {

	public static boolean isUniqueChar(String str) {
		boolean[] char_set = new boolean[256];
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			} 
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "abcd";
		System.out.println(str + " has unque character : " + isUniqueChar(str));

	}

}
