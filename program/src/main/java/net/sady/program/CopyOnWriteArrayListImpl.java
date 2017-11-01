package net.sady.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListImpl {
	
	public static void main(String[] args) {
		
		// creating CopyOnWriteArrayList of type String
        CopyOnWriteArrayList<String> cowalStars = new CopyOnWriteArrayList<>();
        //ArrayList<String> cowalStars = new ArrayList<String>();
 
        // adding elements to CopyOnWriteArrayList
        cowalStars.add("Super Star");
        cowalStars.add("Ultimate Star");
        cowalStars.add("Rock Star");
        cowalStars.add("Little Star");
 
        System.out.println("Iterating using enhanced for-loop:\n");
 
        // iterating CopyOnWriteArrayList using enhanced for-loop
        for(String star : cowalStars) {
            System.out.println(star);
        }
        System.out.println("\n1st: Iteration of COWAL "
                + "completed... !!\n\n");
 
        System.out.println("\n\n2nd: Iterating & removing:\n");
 
        // iterating CopyOnWriteArrayList using Iterator
        Iterator<String> itr = cowalStars.iterator();
        while(itr.hasNext()){
 
            String star = itr.next();
 
            if(star.contains("Super")){
                itr.remove();
            		//cowalStars.add("Little Star2");
            }
            else{
                System.out.println(star);
            }
        }
		
	}

}
