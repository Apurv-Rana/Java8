package com.apurv.apurv.rd.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
	
	final int employeeId;
	transient String  name ;
	transient final String gender ;
	public Employee(int employeeId, String name, String gender) {
		super();
		this.employeeId = employeeId;
		name = name;
		this.gender = gender;
	}
	@Override 
	public String toString()
	{
		
		return "employee id: "+employeeId+"\n name: "+name+"\n gender : "+gender;
	
	
	}

}
