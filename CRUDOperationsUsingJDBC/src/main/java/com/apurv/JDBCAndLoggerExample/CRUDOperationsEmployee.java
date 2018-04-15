package com.apurv.JDBCAndLoggerExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class CRUDOperationsEmployee {
	
	static Logger logger = Logger.getLogger(CRUDOperationsEmployee.class);
	static CRUDOperationsDepartment crudOperationsDepartment = new CRUDOperationsDepartment();
	static CRUDOperationsAddress crudOperationsAddress = new CRUDOperationsAddress();

	public void insertIntoEmployeeTable(Employee employee) {
		
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {
			statement.executeUpdate("INSERT INTO employee VALUES ("+employee.id+",'"+employee.name+"',"+employee.department.getDepartmentId()+")");
			logger.info(employee + " inserted in employee table");
		} catch (SQLException e) {

			logger.error("Invalid department ID");
		}

	}
	
	public void updateEmployee(Employee employee)
	{	
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {

			statement.executeUpdate("update employee set departmentId = "+employee.department.getDepartmentId()+" where employeeId = "+employee.id+" ");
			logger.info("employee department updated to "+employee.department.getDepartmentId() );
		} catch (SQLException e) {

			logger.error("Invalid details !!Update Employee Failed");	
		}

		
	}
	
	public void deleteEmployee(Employee employee)
	{
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {
			
				statement.executeUpdate("delete from employee where employeeId = "+employee.id+" ");
				logger.info("Employee with id "+employee.id + " deleted from employee table");
			} catch (SQLException e) {

				logger.error("Invalid details !! Delete Employee Failed");	
			}
	}
	
	public void readEmployee(Employee employee) {
		
		Employee resultEmployee = null;
		
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
			Statement statement = databaseConnection.createStatement();
			ResultSet employeeData = statement.executeQuery("select * from employee where employeeId = "+employee.getEmployeeId()+"");) {

			while(employeeData.next())
			{
				crudOperationsDepartment.readDepartment(new Department(employeeData.getInt("departmentId")));
				resultEmployee = new Employee(employeeData.getInt("employeeId"),employeeData.getString("employeeName") );
				logger.info("Employee Name: " +resultEmployee.name + " Employee Id : " + resultEmployee.id);
				crudOperationsAddress.readAddress(new Address(resultEmployee));

			}
			
		} catch (SQLException e) {
			logger.error("Invalid Details !!");		
		}
		
		
	}
	
	
}
