package net.sady.interview.array;


/**
 * Given an array of size n, the array contains numbers in range from 0 to k-1
 * where k is a positive integer and k <= n. Find the count of number
 * in this array
 * 
 * let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9,
 * 2, 3}, count the repeation of each element.
 * 
 * Expected time complexity is O(n) and extra space allowed is O(1).
 * Modifications to array are allowed.
 * 
 * @author sakhtar
 *
 */
public class CountNumberOfSameElement {
	

	private void maxRepeatingNumber(int[] arr, int k) {
		
		int n = arr.length;
		for(int i = 0; i< n; i++) {
			arr[arr[i] % k] += k;
		}
		
		//Finding count now
		for(int i = 0; i < k; i++) {
			int originalNum = arr[i] % k;
			int count = (arr[i] - originalNum) / k;
			System.out.println("original Num: " + i + ", Count: " + count );
		}
		
	}
	
	public static void main(String args[]) {
		CountNumberOfSameElement obj = new CountNumberOfSameElement();
		int arr[] = { 1,7,2,1,2,3,4,1,2,7};
 		obj.maxRepeatingNumber(arr, 8);
	}
}
















