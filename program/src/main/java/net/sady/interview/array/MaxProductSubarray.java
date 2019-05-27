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

	private int maxProduct(int[] arr) {
		int neg = 1;
		int pos = 1;
		int maxProduct = arr[0];
		for(int i= 0; i< arr.length; i++) {
			if(arr[i] == 0) {
				neg = 1;
				pos = 1;
				maxProduct = Math.max(maxProduct, 0);
			
			} else if(arr[i] > 0) {
				if(neg < 0 ) {
					neg = neg * arr[i];
				}
				pos = pos * arr[i];
				maxProduct = Math.max(maxProduct, pos);
			
			} else {
				int temp = pos;
				if(neg > 0) {
					pos = 1;
				} else {
					pos = neg * arr[i];
					maxProduct = Math.max(maxProduct, pos);
				}
				neg = temp * arr[i];
			}
			
		}
		return maxProduct;
	}

	public static void main(String args[]) {
		MaxProductSubarray mps = new MaxProductSubarray();
		//int input[] = { 1, 3, 10, 0, 60};
		int input[] = {6, -3, -10, 0, 2};
		System.out.println(mps.maxProduct(input));
	}

}
