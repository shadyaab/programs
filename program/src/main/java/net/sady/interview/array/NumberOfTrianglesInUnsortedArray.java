package net.sady.interview.array;

import java.util.Arrays;

/**
 * Given an unsorted array of positive integers. Find the number of triangles
 * that can be formed with three different array elements as three sides of
 * triangles. For a triangle to be possible from 3 values, the sum of any two
 * values (or sides) must be greater than the third value (or third side).
 * 
 * For example, if the input array is {4, 6, 3, 7}, the output should be 3.
 * There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note
 * that {3, 4, 7} is not a possible triangle.
 * 
 * @author sakhtar
 *
 */
public class NumberOfTrianglesInUnsortedArray {

	private int numberOfTriangles(int[] arr) {
		Arrays.sort(arr);

		int n = arr.length;
		int count = 0;
		int k;
		for (int i = 0; i < n - 2; i++) {
			// int k = i + 2;

			for (int j = i + 1; j < n; j++) {
				k = j + 1;
				while (k < n) {
					if (arr[i] + arr[j] > arr[k]) {
						count++;
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					}
					k++;
				}
			}

		}

		return count;
	}

	public static void main(String args[]) {
		int input[] = { 3, 4, 5, 6, 8, 9, 15 };
		//int input[] = { 10, 21, 22, 100, 101, 200, 300 };
		NumberOfTrianglesInUnsortedArray not = new NumberOfTrianglesInUnsortedArray();
		System.out.println(not.numberOfTriangles(input));
	}
}
