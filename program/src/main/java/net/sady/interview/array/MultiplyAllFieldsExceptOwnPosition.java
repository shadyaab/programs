package net.sady.interview.array;

public class MultiplyAllFieldsExceptOwnPosition {

	private int[] multiply(int[] arr) {
		int n = arr.length;

		int[] left = new int[n];
		int[] right = new int[n];
		int[] result = new int[n];

		left[0] = 1;
		for (int i = 1; i < n; i++) {
			left[i] = left[i - 1] * arr[i - 1];
		}

		right[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] * arr[i + 1];
		}

		for (int i = 0; i < n; i++) {
			result[i] = left[i] * right[i];
		}

		return result;
	}

	public static void main(String args[]) {
		MultiplyAllFieldsExceptOwnPosition maf = new MultiplyAllFieldsExceptOwnPosition();
		int input[] = { 2, 3, 1, 4 };
		int result[] = maf.multiply(input);
		for (int r : result) {
			System.out.print(r + " ");
		}
	}

}
