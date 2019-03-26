package net.sady.interview.array;

/**
 * Given an unsorted array of nonnegative integers, find a continous subarray
 * which adds to a given number
 * 
 * @author sakhtar
 *
 */

class Pair {
	int left;
	int right;

	@Override
	public String toString() {
		return "left: " + left + "; right: " + right;
	}
}

public class SubarrayWithGivenSum {

	private Pair findSubArray(int[] arr, int required) {

		int n = arr.length;
		int left;
		int right;
		int sum;

		for (int i = 0; i < n - 1; i++) {
			left = i;
			right = i + 1;

			sum = arr[i] + arr[right];
			while (sum <= required) {
				sum += arr[++right];
				if(sum == required) {
					Pair pair = new Pair();
					pair.left = left;
					pair.right = right;
					
					return pair;
				}
			}
		}
		return null;
	}

	public static void main(String args[]) {
		SubarrayWithGivenSum sgs = new SubarrayWithGivenSum();
		int arr[] = { 6, 3, 9, 11, 1, 3, 5 };
		Pair pair = sgs.findSubArray(arr, 15);
		System.out.println("Pair: " + pair);
	}
}