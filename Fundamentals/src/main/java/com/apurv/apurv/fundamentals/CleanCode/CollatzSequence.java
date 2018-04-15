package com.apurv.apurv.fundamentals.CleanCode;

import java.util.ArrayList;
public class CollatzSequence {
	
	public static ArrayList<Integer>  getcollatzSequence(int number)
	{
		ArrayList<Integer> collatz = new ArrayList<Integer>();
		System.out.print(number+" ");
		
		while(number!=1)
		{
			
			if(number%2==0)
			{
				number = number/2;
				System.out.print(number+" ");
				
			}
			else
			{
				number = (3*number)+1;
				System.out.print(number+" ");
				
			}
			
			
		}
		return collatz;
		
	
		
	}
public static void main(String[] args )
{
	 getcollatzSequence(3);
	
}
}
