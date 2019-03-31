package net.sady.interview.array;

/**
 * 
 * Given an array of size n, the array contains numbers in range from 0 to k-1
 * where k is a positive integer and k <= n. Find the maximum repeating number
 * in this array
 * 
 * let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9,
 * 2, 3}, the maximum repeating number would be 2
 * 
 * Expected time complexity is O(n) and extra space allowed is O(1).
 * Modifications to array are allowed.
 * 
 * @author shadyaab
 *
 */
public class MaxRepeatingNumber {

	private int maxRepeatingNumber(int[] arr, int k) {

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[arr[i] % k] += k;
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for(int i = 0; i< n; i++){
			if(arr[i] > max){
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String args[]) {
		MaxRepeatingNumber mrn = new MaxRepeatingNumber();
		int arr[] = { 2, 2, 1, 3, 1, 2, 0, 3, 0, 0, 0, 4, 5, 4, 4, 4, 4};
 		System.out.println(mrn.maxRepeatingNumber(arr, 6));
	}

}
