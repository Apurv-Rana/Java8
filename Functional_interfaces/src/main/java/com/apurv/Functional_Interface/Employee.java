package com.apurv.Functional_Interface;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	int employeeId;
	String name;
	String role;
	
	public Employee(int employeeId, String name, String role) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.role = role;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "[EmployeeId=" + employeeId + ", Name=" + name + ", Role=" + role + "]";
	}

	public static List<Employee> getListOfEmployess()
	{
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(1,"Akash","Manager"));
		employees.add(new Employee(2,"Ramesh","Engineer"));
		employees.add(new Employee(3,"Suresh","Accountant"));
		employees.add(new Employee(4,"Jayesh","Accountant"));
		employees.add(new Employee(5,"Karan","Engineer"));
		employees.add(new Employee(6,"Jaivil","Engineer"));
		
		return employees;
	}
}
