package com.apurv.JDBCAndLoggerExample;

public class Address {

	int id;
	String addressOfEmployee;
	Employee employee;
	

	public Address(Employee employee,String addressOfEmployee) {
		this.addressOfEmployee = addressOfEmployee;
		this.employee = employee;
	}
	
	public Address(Employee employee) {

		this.employee = employee;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
