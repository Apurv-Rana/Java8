package com.apurv.JDBCAndLoggerExample;

public class Department {

	int id;
	String name;
	static CRUDOperationsDepartment crudOperationsDepartment = new CRUDOperationsDepartment();
	
	public Department(int id) {
		this.id = id;
		
	}
	
	public Department(int id,String name) {
		this.id = id;
		this.name = name;
		
	}
	public int getDepartmentId() {
		return id;
	}
	public void setDepartmentId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	

	
	
}
