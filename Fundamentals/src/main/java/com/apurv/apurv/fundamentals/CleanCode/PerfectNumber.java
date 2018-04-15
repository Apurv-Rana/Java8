package com.apurv.apurv.fundamentals.CleanCode;


public class PerfectNumber {
	
	
	public static boolean checkPerfectNumber(int number)
	{int sum = 0 ;
boolean result ;
		for (int i =1;i<number; i++)
		{
			if(number%i==0)
			{
				sum=sum+i;
			}
			
			
		}
		
		if(sum == number)
			result = true;
		else 
			result = false ;

return result ;
		
	}

	
	public static void main(String[] args )
	{
		
		System.out.println(checkPerfectNumber(500));
	}
}

