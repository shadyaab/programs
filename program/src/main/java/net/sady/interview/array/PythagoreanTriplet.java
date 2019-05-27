package net.sady.interview.array;

import java.util.Arrays;

public class PythagoreanTriplet {

	private static boolean checkForPythagorean(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			arr[i] *= arr[i]; 
		}
		Arrays.sort(arr);
		
		int left;
		int right;
		for(int i = n -1; i >= 2; i--) {
			left = 0;
			right = i - 1;
			
			while(left < right) {
				if(arr[left] + arr[right] == arr[i]) {
					return true;
				} 
				if(arr[left] + arr[right] < arr[i]) {
					left++;
				} else {
					right--;
				}
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,4,6,3,7,5};
		System.out.println(checkForPythagorean(arr));
	}

	
}
