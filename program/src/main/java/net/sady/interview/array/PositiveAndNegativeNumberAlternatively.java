package net.sady.interview.array;

public class PositiveAndNegativeNumberAlternatively {

	private void arrange(int[] arr) {
		int n = arr.length;
		int pos = segregate(arr);
		
		int left = 0;
		while (left < pos && pos < n) {
			
			swap(arr, left, pos);
			left +=2;
			pos++;
		}

	}

	private int segregate(int[] arr) {
		int n = arr.length;
		int left = 0;
		int right = n - 1;
		while (left < right) {
			if (arr[left] < 0) {
				left++;
			} else if (arr[right] >= 0) {
				right--;
			} else {
				swap(arr, left, right);
			}
		}
		return left;
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String args[]) {
		// int arr[] = { -1, -2, -3, -4, -5, 1, 2, 3, 4, 5 };
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		// int arr[] = { -1, -7, -3, 4, 5, 6, 2, 8, 9 };
		// int arr[] = { 9, -7, -3, 4, 5, 6, 2, 8, -1 };
		// int arr[] = { 9, -7, 8, -3, 5, -1, 2, 4, 6 };
		PositiveAndNegativeNumberAlternatively pan = new PositiveAndNegativeNumberAlternatively();
		pan.arrange(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
