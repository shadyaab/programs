package net.sady.interview.array;


/**
 * Given a set of n integers, divide the set in two 
 * subsets of n/2 sizes each such that the difference 
 * of the sum of two subsets is as minimum as possible. 
 * If n is even, then sizes of two subsets must be 
 * strictly n/2 and if n is odd, then size of one subset 
 * must be (n-1)/2 and size of other subset must be (n+1)/2.
 * 
 * @author sakhtar
 *
 */
public class TugOfWar {
	
	public static void main(String[] args) {
		
		int [] arr = {2, 8, 4, 5, 1};
		partition(arr);	
	}
	private static int partition(int[] arr) {
		int n = arr.length;
		int[] used = new int[n];
		int[] partition = new int[n];
		int left = 0;
		int right = n-1;
		
		for(int i = 0; i< n/2; i++) {
			int k = findNearest(arr, used);
			int j = findNearest(arr, used);
			if(leftSum(arr, left) <= rightSum(arr, right)) {
				partition[left++] = Math.max(arr[k], arr[j]);
				partition[right--] = Math.min(arr[k], arr[j]);
			} else {
				partition[left++] = Math.min(arr[k], arr[j]);
				partition[right--] = Math.max(arr[k], arr[j]);
			}
			used[k] = 1;
			used[j] = 1;
		}
		
		if(n%2 == 1) {
			int idx = findNearest(arr, used);
			partition[right] = arr[idx];
		}
		
		return Math.abs(leftSum(arr, left) - rightSum(arr, right));
	}
	
	
	
	private static int findNearest(int[] arr, int[] used) {
		
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i= 0; i< arr.length; i++) {
			if(used[i] == 1) {
				continue;
			}
			if(arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private static int rightSum(int[] arr, int right) {
		int sum = 0;
		for(int i = right - 1; i >= 0; i--) {
			sum += arr[i];
		}
		return sum;
	}
	private static int leftSum(int[] arr, int left) {
		int sum = 0;
		for(int i = 0; i < left; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	
}


















