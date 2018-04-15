package com.apurv.apurv.collection.math;

import java.util.Scanner;

public class Main {
	
	public static Scanner s = new Scanner(System.in);
	public static int getLength()
	{
	System.out.println("enter the length of array ");
	return s.nextInt();
	}
	
	public static double[] getArray(int length)
	{
		double[] array =new double[length];
		System.out.println("please enter array elements");
		for(int i=0;i<length;i++)
		{
		array[i]=s.nextDouble();
		}
		return array;
	}

	public static void main(String[] args)
	{
		MathImpls math = new MathImpls();
		System.out.println("Sum : "+math.getSum(getArray(getLength())));
		System.out.println("Average:"+math.getAverage(getArray(getLength())));
	}
	
}
