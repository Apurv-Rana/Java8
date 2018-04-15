package com.apurv.apurv.Pyramid;

public class Pyramid {
	 public static void getPyramid(int row , int number)
	    {
	        int k=1;
	        for(int i=0;i<row;i++)
	        {
	            
	            for(int j=0;j<=i;j++)
	            {
	                System.out.print(number*k +"\t");
	                k++;
	            }
	            System.out.println();
	    }}
	    
	
	

}
