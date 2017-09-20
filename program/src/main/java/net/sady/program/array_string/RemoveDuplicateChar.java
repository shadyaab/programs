package net.sady.program.array_string;

import java.util.Arrays;

public class RemoveDuplicateChar {

	public static char[] removeDuplicate(String str) {
		char[] ch = str.toCharArray();
		boolean[] char_set = new boolean[256];
		int tail = 0;
		for(int i = 0; i < ch.length; i++) {
			int val = ch[i];
			if(!char_set[val]) {
				char_set[val] = true;
				ch[tail] = ch[i];
				tail++;
			} 
		}
		ch[tail] = 0;
		System.out.println(ch);
		return ch;
	}
	
	public static void main(String[] args) {
		String str = "shadyaab";
		System.out.println(str + " without duplicate : " + Arrays.toString(removeDuplicate(str)));
	}

}
