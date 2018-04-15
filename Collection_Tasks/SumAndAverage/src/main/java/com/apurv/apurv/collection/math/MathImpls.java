package com.apurv.apurv.collection.math;

import java.util.Scanner;

public class MathImpls implements 	Math {
	public static Scanner s =new Scanner(System.in);
	
	
	
	public double getSum(double[] array) {
		
		 double sum = 0;
	        int length = array.length;
	        for(int i=0;i<length;i++)
	        {
	            sum = sum +array[i];
	        }
	        return sum;
	}

	public double getAverage(double[] array) {
		// TODO Auto-generated method stub

        double sum = 0;
        int length = array.length;
        for(int i=0;i<length;i++)
        {
            sum = sum +array[i];
        }
        
        return sum / length;
	}

}
