package com.apurv.apurv.collection.metric;

import java.util.Scanner;

public class Main {
	
	static Scanner s = new Scanner(System.in);
		public static void display()
			{
			
				System.out.println("1 : Inches to Feet");
				System.out.println("2 : Inches to Meters");
				System.out.println("3 : Feet to Inches");
				System.out.println("4 : Feet to Meters");
				System.out.println("5 : Meters to Inches");
				System.out.println("6 : Meters to Feet");
				System.out.println("7 : Exit");
				
			} 
			
			public static boolean isExit(int choice)
			{
				return choice == 7;
			}
			public static boolean isValidChoice(int choice)
			{
				return choice >=1 && choice <=6 ;
			}
			
			public static void main(String args[])
			{
				
				 while(true)
				{
					display();
					
					System.out.println("please Enter choice:");
					int choice = s.nextInt();
					if(isExit(choice))
						break;
					else if(isValidChoice(choice))
					{
						System.out.println("please Enter value:");
						double value = s.nextDouble();
						System.out.println("The answer is " + ConverterFactory.getConverter(choice).convert(value));
					}
					else
						System.out.println("opps Invalid Choice");
				}
					
			}
	}

