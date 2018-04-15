package com.apurv.Functional_Interface;

import java.util.List;
import java.util.function.Consumer;


public class ConsumerExampleMain {

	public static void main(String[] args) {
		
		
		List<Employee> employees =Employee.getListOfEmployess();
		
		Consumer<Employee> consumer = (Employee e)->System.out.println(e);
		
		displayEmployees(employees,consumer);
	}

	private static void displayEmployees(List<Employee> employees, Consumer<Employee> consumer) {
		// TODO Auto-generated method stub
		
		for(Employee e:employees)
			consumer.accept(e);
	}

	
	
}
