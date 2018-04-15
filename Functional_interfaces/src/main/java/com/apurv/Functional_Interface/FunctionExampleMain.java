package com.apurv.Functional_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExampleMain {

	public static void main(String[] args) {
		
		Function<Integer, Integer> toAbsoluteValue = (Integer i) -> Math.abs(i);
	
		List<Integer> absoluteValuesOfIntegers=getAbsoluteValues(getListOfIntegers(),toAbsoluteValue);
		
		System.out.println(absoluteValuesOfIntegers);
	}

	private static List<Integer> getListOfIntegers() {
		List<Integer> integers = new ArrayList<Integer>();
		
		integers.add(-1);
		integers.add(-18);
		integers.add(-125);
		integers.add(1);
		integers.add(-1145);
		integers.add(50);
		
		return integers;
	}

	private static List<Integer> getAbsoluteValues(List<Integer> integers, Function<Integer, Integer> absoluteValue) {
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i :integers)
			result.add(Math.abs(i));
		
		return result;
	}
}
