package com.apurv.JDBCAndLoggerExample;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class MainDriverClass {

	static Logger logger = Logger.getLogger(MainDriverClass.class);
	static Scanner inputFromConsole = new Scanner(System.in);
	static CRUDOperationsDepartment crudOperationsDepartment = new CRUDOperationsDepartment();
	
	public static void main(String[] args) {		
		
			showMenu();
			int choice = inputFromConsole.nextInt();
				
			switch(choice)
			{
			case 1:DepartmentMain.main(args);
				break;
			case 2:EmployeeMain.main(args);
				break;
			default :logger.info("Wrong choice");
				
			}
		
		
		}

	private static void showMenu() {
		
		logger.info("Enter your choice:");
		logger.info("1. Department Operations ");
		logger.info("2. Employee Operations");
		
		
	}
		
		

}
