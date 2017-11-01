package net.sady.program.all;

public class DecimalToBinary {
	
	public Integer[] convertDecimalToBinary(int num) {
		Integer binary [] = new Integer[25];
		int idx= 0;
		while (num > 0) {
			binary[idx++] = num % 2;
			num /= 2;
		}
		
		return binary;
	}
	
	public static void main(String[] args) {
		DecimalToBinary obj = new DecimalToBinary();
		Integer [] binaryNumber = obj.convertDecimalToBinary(12);
		
		for (int i = binaryNumber.length - 1; i >= 0 ; i--) {
			if(binaryNumber[i] != null)
				System.out.print(binaryNumber[i]);
		}
	}

}
