package net.sady.interview.array;

/**
 * Given an unsorted array arr[] and two numbers x and y, find the minimum
 * distance between x and y in arr[]. The array might also contain duplicates.
 * You may assume that both x and y are different and present in arr[].
 * 
 * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6 Output:
 * Minimum distance between 3 and 6 is 4.
 * 
 * @author sakhtar
 *
 */
public class MinimumDistanceBetweenTwoNumbers {

	private int minDistance(int[] arr, int x, int y) {

		int n = arr.length;
		int pointer = -1;
		int foundValue = -1;
		int minCount = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			if (arr[i] == x) {
				if (foundValue == -1) {
					foundValue = x;
					pointer = i;
				} else if (foundValue == x) {
					pointer = i;
				} else {
					minCount = (i - pointer) < minCount ? (i - pointer) : minCount;
					foundValue = x;
					pointer = i;
				}

			} else if (arr[i] == y) {
				if (foundValue == -1) {
					foundValue = y;
					pointer = i;
				} else if (foundValue == y) {
					pointer = i;
				} else {
					minCount = (i - pointer) < minCount ? (i - pointer) : minCount;
					foundValue = y;
					pointer = i;
				}
			}
		}
		return minCount;
	}

	public static void main(String args[]) {
		MinimumDistanceBetweenTwoNumbers mdb = new MinimumDistanceBetweenTwoNumbers();
		int input[] = { 1, 5, 5, 2, 6 };
		// int input[] = { 6, 4, 1, 5, 6, 9, 10, 4, 6, 6 };
		// int input[] = { 1, 2, 5, 3, 5, 4, 4, 2, 3 };
		System.out.println(mdb.minDistance(input, 5, 6));
	}

}
