package com.apurv.Functional_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExampleMain {
	
	List<Integer> listOne = new ArrayList<Integer>(); 
    List<Integer> listTwo = new ArrayList<Integer>(); 
	
	
	public static void main(String[] args) {
		
			BiConsumerExampleMain biConsumerExample = new BiConsumerExampleMain();
			biConsumerExample.populateListOne();
			biConsumerExample.populateListTwo();
		 	BiConsumer<List<Integer>, List<Integer>> biConusmer = getBiConsumer();
		 		
		 	biConusmer.accept(biConsumerExample.listOne, biConsumerExample.listTwo);
	  
	}

	private void populateListTwo() {
		// TODO Auto-generated method stub
		listTwo.add(2); 
		listTwo.add(1); 
		listTwo.add(3); 

	}

	private void populateListOne() {
		// TODO Auto-generated method stub

		listOne.add(2); 
		listOne.add(1); 
		listOne.add(3); 

		
	}

	private static BiConsumer<List<Integer>, List<Integer>> getBiConsumer() {
		// TODO Auto-generated method stub
		
		BiConsumer<List<Integer>, List<Integer> > equals = (listOne, listTwo) -> 
        { 
            if (listOne.size() != listTwo.size()) { 
                System.out.println("False"); 
            } 
            else { 
                for (int i = 0; i < listOne.size(); i++) 
                    if (listOne.get(i) != listTwo.get(i)) { 
                        System.out.println("False"); 
                        return; 
                    } 
                System.out.println("True"); 
            } 
        }; 
        
        return equals;
	}

	
}
