package com.apurv.Functional_Interface;

import java.util.Scanner;
import java.util.function.Supplier;

class StringFactory
{
	static String getHelloStringInstance()
	{
		return new String("Hello ");
	}
}

public class SupplierExampleMain {
	
	
	public static void main(String[] args) {
		
		Supplier<String> supplier = ()->StringFactory.getHelloStringInstance();
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String name = scanner.nextLine();
		
		System.out.println(supplier.get() + name);
		
		scanner.close();
	}
	

}
