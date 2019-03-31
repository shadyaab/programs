package net.sady.interview.array;

/**
 * Given an array that contains both positive and 
 * negative integers, find the product of the 
 * maximum product subarray. 
 * 
 * Expected Time complexity is O(n) and only O(1) extra space can be used.
 * 
 * Input: arr[] = {6, -3, -10, 0, 2}
 * Output:   180  // The subarray is {6, -3, -10}
 * 
 * @author shadyaab
 *
 */
public class MaxProductSubarray {

	private int maxProduct(int[] input) {
		return 0;
	}

	public static void main(String args[]) {
		MaxProductSubarray mps = new MaxProductSubarray();
		int input[] = { -6, -3, 8, -9, -1, -1, 3, 6, 9, 0, 3, -1 };
		System.out.println(mps.maxProduct(input));
	}

}
