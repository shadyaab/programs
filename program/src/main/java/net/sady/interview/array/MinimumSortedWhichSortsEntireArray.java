package net.sady.interview.array;

/**
 * Given an unsorted array arr[0..n-1] of size n, 
 * find the minimum length subarray arr[s..e] such that 
 * sorting this subarray makes the whole array sorted.
 * 
 * If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], 
 * your program should be able to find that the subarray 
 * lies between the indexes 3 and 8.
 * 
 * @author sakhtar
 *
 */
public class MinimumSortedWhichSortsEntireArray {

	private int minLength(int[] arr) {

		int n = arr.length;
		int left = 0;
		int right = n -1;
        while(left < n -1 && arr[left] < arr[left+1]) {
        	left++;
        }
        if(left == n-1) {
        	return 0;
        }
        
        while(right > 0 && arr[right] > arr[right- 1]) {
        	right--;
        }
        
        //find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++) {
        	if(arr[i] < min) {
        		min = arr[i];
        	}
        	if(arr[i] > max) {
        		max = arr[i];
        	}
        }
		
        while(left >= 0 && arr[left] > min) {
        	left--;
        }
        while(right < n-1 &&  arr[right] < max) {
        	right++;
        }
		
        return right - left -2 + 1;
	}

	public static void main(String args[]) {
		int arr[] = { 4, 5, 10, 21, 18, 23, 7, 8, 19, 34, 38 };
		//int arr1[] = { 4, 5, 6, 12, 11, 15 };
		//int arr2[] = { 4, 5, 6, 10, 11, 15 };
		MinimumSortedWhichSortsEntireArray msw = new MinimumSortedWhichSortsEntireArray();
		int res = msw.minLength(arr);
		System.out.println(res);
	}

}
