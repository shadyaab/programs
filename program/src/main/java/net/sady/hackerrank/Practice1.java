package net.sady.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {
	public static void main(String[] args) {
		
		//staircase(3);
		System.out.println(timeConversion("12:01:10PM"));
		int [] c =  {2,4,1,5,8,4,2,1};
		Arrays.stream(c)
			.forEach(System.out::println);
		System.out.println(c);
		int temp = 0;
		for(int i = 0; i < c.length; i++){
            for(int j = 0; j< c.length; j++){
                if(j < c.length-1  && c[j] < c[j+1]){
                    temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }
		Arrays.stream(c)
		.forEach(System.out::println);
		
		
	}
	
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<Integer>();
        int resultA =0;
        int resultB =0;
        for(int i=0; i<3; i++){
            if(a.get(i) > b.get(i)){
                resultA++;
            } else if(a.get(i) < b.get(i)){
                resultB++;
            } 
        }
        result.add(resultA);
        result.add(resultB);
        return result;
    }
	
	static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar)
        		.reduce(0,(a,b) -> a+b);

    }
	
	// Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int diag1 = 0;
        int diag2 = 0;
        int length = arr.length - 1;
        for(int i = 0; i <= length; i++){
            for(int j = 0; j <= length; j++){
                if(i==j){
                    diag1 += arr[i][i]; 
                }
                if(i+j == length){
                    diag2 += arr[i][j];
                }
            }
        }
        return Math.abs(diag1 - diag2);

    }
    
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int length = arr.length;
        int positiveNumbers = 0;
        int negativeNumbers = 0;
        for(int i=0; i< length; i++){
            if(arr[i] > 0){
                positiveNumbers++;
            } else if(arr[i] < 0){
                negativeNumbers++;
            }
        }
        System.out.println((double)positiveNumbers/(double)length);
        System.out.println((double)negativeNumbers/(double)length);
        System.out.println((double)(length - (positiveNumbers + negativeNumbers))/(double)length);
    }
    
    static void staircase(int n) {
        for(int i = 0; i < n; i++){
            for(int j= 0; j <n ; j++){
                if(i+j >= n-1){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                } 
                if( j == n-1){
                    System.out.println("");
                }
            }
        }
    }
    static void miniMaxSum(int[] arr) {
        int max = -1;
        int min = -1;
        for(int i=0; i< arr.length; i++){
            int sum = 0;
            for(int j=0; j < arr.length; j++){
                if(i != j){
                    sum += arr[j];
                }
            }
            if( sum > max){
                max = sum;
            }
            if(min > sum || min == -1){
                min = sum;
            }
        }
        System.out.println(min + " " + max);
    }
    
    static int birthdayCakeCandles(int[] ar) {
        int max = ar[0];
        int count = 1;
        for(int i = 1; i< ar.length; i++){
            if(ar[i] > max){
                max = ar[i];
                count = 1;
            } else if (ar[i] == max){
                count++;
            }
        }
        return count;
    }
    
    static String timeConversion(String s) {
        String am_pm = s.substring(8);
        String hourInString = s.substring(0,2);
        int hour = Integer.parseInt(hourInString);
        if(hour == 12 && am_pm.equals("AM")){
            hourInString = "00";
        } else if (am_pm.equals("PM") && hour != 12 ){
            hourInString = hour + 12 + "";
        }
        return hourInString + s.substring(2,8);
    }
    
    static int getMinimumCost(int k, int[] c) {
        int temp = 0;
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j< c.length; j++){
                if(j < c.length-1  && c[j] < c[j+1]){
                    temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }
        int previousCount = -1;
        int totalMinimumCost = 0;
        for(int i = 0; i<c.length; i++){
            if(i % k == 0){
                previousCount++;
            }
            totalMinimumCost += (previousCount + 1) * c[i];
        }
        return totalMinimumCost;
    }
}









