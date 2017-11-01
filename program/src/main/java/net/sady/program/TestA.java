package net.sady.program;

public class TestA {

	
	public static void funcA(int N, int piles, int [] coins) {
		for (int i = 0; i < N; i++) {
            
            //Logic start here
            int count = 0;
            int turn = 0;
            while(count < coins.length){
                int minIdx = 0;
                for(int idx = 0; idx < coins.length; idx++){
                    if(coins[idx] % 2 == 0) {
                        if(coins[idx] < coins[minIdx]){
                        		minIdx = idx;
                        }
                    } else {
                    		minIdx++;
                    }
                }
                System.out.println(minIdx + " " +  coins[minIdx]);
                while(coins[minIdx] % 2 == 0){
                    coins[minIdx] /= 2;
                    turn++;
                }
                count++;
            }
            System.out.println(turn);
            if(turn % 2 == 0){
                System.out.println("Alan");
            } else{
                System.out.println("Charlie");
            }
            
        }
	}
	public static void main(String[] args) {
		int [] arr = {4,6,4};
		funcA(1, 2, arr);
	}

}
