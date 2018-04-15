package com.apurv.Functional_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExampleMain {

	public static void main(String[] args) {
		
		List<Employee> employees =Employee.getListOfEmployess();
		
		Predicate<Employee> predicate = (Employee employee)-> employee.getRole().equals("Engineer");
		
		List<Employee> engineers = getEngineers(employees,predicate);
		System.out.println(engineers);
	}

	private static List<Employee> getEngineers(List<Employee> employees, Predicate<Employee> predicate) {
		// TODO Auto-generated method stub
		List<Employee> result = new ArrayList<Employee>();
		for(Employee e:employees)
			if(predicate.test(e))
				result.add(e);
		
		return result;
	} 
	
}
