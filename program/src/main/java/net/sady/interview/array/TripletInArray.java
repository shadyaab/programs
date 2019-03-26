package net.sady.interview.array;

import java.util.Arrays;

/**
 * find-a-triplet-that-sum-to-a-given-value
 * 
 * @author sakhtar
 *
 */

class Triplet {
	int a;
	int b;
	int c;

	public String toString() {
		return "a = " + a + "; b = " + b + "; c = " + c;
	}
}

public class TripletInArray {

	public static void main(String args[]) {
		TripletInArray tip = new TripletInArray();
		int input[] = { 1, 2, 6, 9, 11, 18, 26, 28 };
		//int input[] = { 2, 8, 4, 5, 1 };
		int sum = 22;
		Triplet triplet = tip.findTriplet(input, sum);
		System.out.println(triplet);
	}

	private Triplet findTriplet(int[] arr, int sum) {
		Arrays.sort(arr);
		
		int n = arr.length;
		
		for(int i = 0; i < n -2; i++) {
			int left = i + 1;
			int right = n - 1;
			int rem_sum = sum - arr[i];
			
			while(left < right) {
				if(rem_sum == arr[left] + arr[right]) {
					Triplet triplet = new Triplet();
					triplet.a = arr[i];
					triplet.b = arr[left];
					triplet.c = arr[right];
					
					return triplet;
				}
				if(arr[left] + arr[right] < rem_sum) {
					left++;
				} else {
					right--;
				}
			}
		}
		return null;
	}
}










