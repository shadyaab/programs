package net.sady.interview.array;

/**
 * Move all zeros to the right
 * 
 * @author sakhtar
 *
 */
public class MoveAllZerosToEnd {

	private void moveZeros(int[] arr) {
		
		int n = arr.length;
		int left = 0;
		int right = n-1;
		while(left < right ) {
			if(arr[left] != 0) {
				left++;
			} else if(arr[right] == 0) {
				right--;
			} else {
				arr[left] = arr[right];
				arr[right] = 0;
				left++;
				right--;
			}
		}
	}
	


	public static void main(String args[]) {
		MoveAllZerosToEnd maz = new MoveAllZerosToEnd();
		int arr[] = { 0, 0, 1, 2, 0, 5, 6, 7, 0 };
		maz.moveZeros(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
