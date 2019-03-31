package net.sady.interview.array;

/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 * 
 * Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
 * Output: 6  (j = 7, i = 1)
 * 
 * @author shadyaab
 *
 */
public class MaximumIminusJSuchThatAiGTAj {
	class Res{
		int j;
		int i; 
		
		public String toString() {
			return "i = " + i + " j: " + j;
		}
	}
	private Res maximumGeeks(int[] arr) {
		
		int n = arr.length;
		int left = 0;
		int right = n-1;
		int max = Integer.MIN_VALUE;
		Res res= new Res();
		
		for(left = 0; left < n -1; left++){
			right = n - 1;
			
			while(arr[left] > arr[right]){
				right--;
			}
			
			if(max < (right - left)){
				max = right-left;
				res.i = left;
				res.j = right;
			}
		}
		return res;
	}
	
	//This is 2nd solution which is more optimal
	public int maximumGeeksSolution2(int input[]){
        int lhs[] = new int[input.length];
        int rhs[] = new int[input.length];
        lhs[0] = 0;
        for(int i=1; i < lhs.length; i++){
            if(input[lhs[i-1]] < input[i]){
                lhs[i] = lhs[i-1];
            }else{
                lhs[i] = i;
            }
        }
        rhs[input.length-1] = input.length-1;
        for(int i=input.length-2; i >= 0; i--){
            if(input[rhs[i+1]] > input[i]){
                rhs[i] = rhs[i+1];
            }else{
                rhs[i] = i;
            }
        }
        
        int i=0;
        int j=0;
        int max = 0;
        for(;j < input.length;){
            if(input[lhs[i]] < input[rhs[j]]){
                max = Math.max(max, j-i);
                j++;
            }else{
                i++;
            }
        }
        return max;
    }

	public static void main(String args[]) {
		MaximumIminusJSuchThatAiGTAj mj = new MaximumIminusJSuchThatAiGTAj();
		//int input[] = { 11, 14, 13, 1, 4, 13, 1, 10 };
		int input[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		Res res = mj.maximumGeeks(input);
		
		//System.out.println(mj.maximumGeeksSolution2(input));
		System.out.println(res);
	}

}
