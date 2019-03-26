package net.sady.interview.array;

/**
 * Given an unsorted array of size n. Array elements are in the range from 1 to
 * n. One number from set {1, 2, …n} is missing and one number occurs twice in
 * the array. Find these two numbers.
 * 
 * @author sakhtar
 *
 */
class Result {
	int missing;
	int repeating;

	@Override
	public String toString() {
		return "Missing: " + missing + "; Repeating: " + repeating;
	}
}

/**
 * Another solution would be using the same array if
 * the space complexity is the concern.
 * 
 * @author sakhtar
 *
 */
public class RepeatingAndMissingNumber {

	private Result findNumbers(int[] arr) {

		int n = arr.length;
		int[] check = new int[n + 1];
		Result result = new Result();

		for (int i = 0; i < n - 1; i++) {

			if (check[arr[i]] == 1) {
				result.repeating = arr[i];
				break;
			}
			check[arr[i]] = 1;
		}
		for (int i = 1; i <= n; i++) {
			if (check[i] != 1) {
				result.missing = i;
				break;
			}
		}

		return result;

	}

	public static void main(String args[]) {
		RepeatingAndMissingNumber rmn = new RepeatingAndMissingNumber();
		int arr[] = { 3, 1, 2, 4, 6, 8, 2, 7 };
		Result result = rmn.findNumbers(arr);
		System.out.println(result);
	}
}
