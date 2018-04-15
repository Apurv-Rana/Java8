package com.apurv.apurv.fundamentals.CleanCode;


public class DegreeConversion {

	public static void main(String[] args )
	{
		int first_argument = Integer.parseInt(args[0]);

		int second_argument =Integer.parseInt(args[1]);
		
		
		if(first_argument==0) {
			
			System.out.println(((second_argument-32)*5)/9);
			
		 }
		else
		{
			System.out.println((second_argument*1.8)+32);
		}
		
		
	}
}

