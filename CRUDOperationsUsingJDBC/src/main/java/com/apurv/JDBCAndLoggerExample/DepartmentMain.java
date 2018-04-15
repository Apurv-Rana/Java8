package com.apurv.JDBCAndLoggerExample;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class DepartmentMain {

	static Logger logger = Logger.getLogger(DepartmentMain.class);
	static Scanner inputFromConsole = new Scanner(System.in);
	static CRUDOperationsDepartment crudOperationsDepartment = new CRUDOperationsDepartment();

	public static void main(String[] args) {

		showMenu();
		int choice = inputFromConsole.nextInt();
		
		switch(choice)
		{
		case 1:
			crudOperationsDepartment.insertIntoDepartmentTable(new Department(getDepartmentIdFromUser(),getDepartmentNameFromUser()));
			break;
		case 2:
			crudOperationsDepartment.updateDepartment(new Department(getDepartmentIdFromUser(),getDepartmentNameFromUser()));
			break;
		case 3:
			crudOperationsDepartment.readDepartment(new Department(getDepartmentIdFromUser()));
			break;
		case 4:
			crudOperationsDepartment.deleteDepartment(new Department(getDepartmentIdFromUser()));
			break;
		default:
			logger.info("Wrong choice");
		}

	}

	private static void showMenu() {
		
		logger.info("Enter your choice:");
		logger.info("1. Create New Department");
		logger.info("2. Update Department");
		logger.info("3. Get Department Details");
		logger.info("4. Delete Department");

	}

	private static int getDepartmentIdFromUser() {

		logger.info("Enter Department Id :");
		return inputFromConsole.nextInt();

	}

	private static String getDepartmentNameFromUser() {

		inputFromConsole.nextLine();
		logger.info("Enter Department Name:");
		return inputFromConsole.nextLine();
		
		
	}

}
