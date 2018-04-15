package com.apurv.JDBCAndLoggerExample;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class EmployeeMain {
	
	static Logger logger = Logger.getLogger(EmployeeMain.class);
	static Scanner inputFromConsole = new Scanner(System.in);
	static CRUDOperationsEmployee crudOperationsEmployee = new CRUDOperationsEmployee();
	static CRUDOperationsDepartment crudOperationsDepartment = new CRUDOperationsDepartment();
	static CRUDOperationsAddress crudOperationsAddress = new CRUDOperationsAddress();
	
	public static void main(String[] args) {
		
		showMenu();

		int choice = inputFromConsole.nextInt();

		switch(choice)
		{
		case 1:
			crudOperationsEmployee.insertIntoEmployeeTable(new Employee(getEmployeeId(), getEmployeeName(), new Department(getEmployeeDepartmentId())));
			break;
		case 2:
			crudOperationsEmployee.updateEmployee(new Employee(getEmployeeId(), new Department(getEmployeeDepartmentId())));
			break;
		case 3:
			crudOperationsEmployee.readEmployee(new Employee(getEmployeeId()));
			break;
		case 4:
			crudOperationsEmployee.deleteEmployee(new Employee(getEmployeeId()));
			break;
		case 5:
			crudOperationsAddress.insertAddress(new Address(new Employee(getEmployeeId()),getEmployeeAddress()));
			break;
		case 6:
			crudOperationsAddress.deleteAddress(new Address(new Employee(getEmployeeId())));
			break;
		default:
			logger.info("Wrong choice");
		}

		
	}

	private static void showMenu() {
		
		logger.info("Enter your choice:");
		logger.info("1. Create New Employee");
		logger.info("2. Update Employee Department");
		logger.info("3. Get Employee details");
		logger.info("4. Delete employee");
		logger.info("5. Add employee Address");
		logger.info("6. Delete All Addresses for employee");
		
		
	}
	private static String getEmployeeName()
	{
		inputFromConsole.nextLine();
		logger.info("Enter Employee Name");
		return inputFromConsole.nextLine();
	}
	private static int getEmployeeId()
	{
		logger.info("Enter Employee Id");
		return inputFromConsole.nextInt();
	}
	private static int getEmployeeDepartmentId()
	{
		logger.info("Enter Employee DepartmentId");
		return inputFromConsole.nextInt();
	}
		
	private static String getEmployeeAddress()
	{
		inputFromConsole.nextLine();
		logger.info("Enter Employee Address");
		return inputFromConsole.nextLine();
	}
	

}
