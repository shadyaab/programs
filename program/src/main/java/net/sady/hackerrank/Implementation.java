package net.sady.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Implementation {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(233);
		
		int [] arr = new int[2];
		list.toArray();
		System.out.println(arr);
	}
	
	static int getTotalX(int[] a, int[] b) {
        int count = 0; 

        ExternalLoop: 
        for(int i = a[a.length - 1]; i <= b[0]; i++){
            
            for(int j = 0; j< a.length; j++){
                if(i % a[j] != 0){
                    continue ExternalLoop;
                }
            }
            for(int z = 0; z < b.length; z++){
                if(b[z] % i != 0){
                    continue ExternalLoop;
                }
            }
            count++;
        }
        return count;
    }
	
	static int[] breakingRecords(int[] scores) {
        int best = scores[0];
        int worst = scores[0];
        int[] result = new int[2];
        int bestCount = 0;
        int worstCount = 0;

        for(int i = 0; i< scores.length; i++){
            if(scores[i] > best){
                best = scores[i];
                bestCount++;
            }
            if(scores[i] < worst){
                worst = scores[i];
                worstCount++;
            }
        }
        result[0] = bestCount;
        result[1] = worstCount;
        return result;
    }
	
	static int birthday(List<Integer> s, int d, int m) {
        Integer [] segment = new Integer [s.size()]; 
        s.toArray(segment);
        int count = 0;
        int sum = 0;

        for(int i = 0; i < segment.length - m + 1 ; i++){
            sum = 0;
            for(int j=i; j < m+i; j++){
                sum += segment[j];
            }
            if(sum == d){
                count++;
            }
        }
        return count;
    }
	
}








