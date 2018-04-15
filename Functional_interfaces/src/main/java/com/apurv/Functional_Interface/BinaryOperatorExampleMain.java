package com.apurv.Functional_Interface;

import java.util.function.BinaryOperator;

public class BinaryOperatorExampleMain {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> addition = (Integer a,Integer b) -> a+b;
		System.out.println("10 + 12 : "+addition.apply(10, 12));
		
		BinaryOperator<Integer> subtraction = (Integer a,Integer b) -> a-b;
		System.out.println("10 - 1 : "+subtraction.apply(10, 1));
		
		BinaryOperator<Integer> multiplication = (Integer a,Integer b) -> a*b;
		System.out.println( "10 * 12 : "+multiplication.apply(10, 12));
		
		BinaryOperator<Integer> division = (Integer a,Integer b) -> a/b;
		System.out.println( "10 / 2 : "+division.apply(10, 2));
		
		
	}
	
	
	
}
