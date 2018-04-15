package com.apurv.JDBCAndLoggerExample;

public class Employee {
	
	int id;
	String name;
	Department department;

	public Employee(int id) {
		this.id = id;
	}


	public Employee(int id, Department department) {
		
		this.id = id;
		this.department = department;
	}
	
	public Employee(int id, String name) {
		
		this.id = id;
		this.name = name;
		
	}
	
	public Employee(int id, String name, Department department) {
		
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
	public int getEmployeeId() {
		return id;
	}
	public void setEmployeeId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department.id + "]";
	}


}
