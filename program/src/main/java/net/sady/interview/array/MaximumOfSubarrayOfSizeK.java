package net.sady.interview.array;

public class MaximumOfSubarrayOfSizeK {

	private int[] maxSubArray(int[] input, int i) {
		return null;
	}

	public static void main(String args[]) {
		int input[] = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
		MaximumOfSubarrayOfSizeK msa = new MaximumOfSubarrayOfSizeK();
		int max[] = msa.maxSubArray(input, 4);
		for (int i : max) {
			System.out.print(i + " ");
		}
	}

}
