package com.apurv.JDBCAndLoggerExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class CRUDOperationsAddress {

	static Logger logger = Logger.getLogger(CRUDOperationsEmployee.class);
	static CRUDOperationsEmployee crudOperationsEmployee = new  CRUDOperationsEmployee();
	
	public void insertAddress(Address address)
	{
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {
			
			statement.executeUpdate("INSERT INTO address(address,employeeId) VALUES ('"+address.addressOfEmployee+"',"+address.employee.getEmployeeId()+")");
			logger.info("Address inserted Successfully  for employeeId" + address.employee.getEmployeeId());

		} catch (SQLException e) {
	
			logger.error("Invalid Employee Id");
		}

	}
	
	public void deleteAddress(Address address)
	{
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {

			statement.executeUpdate("delete from address where employeeId = '"+address.employee.getEmployeeId()+"'");
			logger.info("Address deleted Successfully for employeeId" + address.employee.getEmployeeId());

	
		} catch (SQLException e) {

			logger.error("Invalid Employee Id");

		}

	}

	public void readAddress(Address address) {
		
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement =databaseConnection.createStatement();
			ResultSet employeeAddress = statement.executeQuery("select * from address where employeeId = "+address.employee.getEmployeeId()+"");) {

			boolean flag=true;
			int addressNumber=1;
			while(employeeAddress.next())
			{
				flag=false;
				logger.info("Address "+ addressNumber + " =  " + employeeAddress.getString("address"));
			}
			if(flag)
				logger.info("No Address available for employee with id " + address.employee.getEmployeeId());


		} catch (SQLException e) {
			logger.error("Invalid employee Id !!");		
		}
	}
}
