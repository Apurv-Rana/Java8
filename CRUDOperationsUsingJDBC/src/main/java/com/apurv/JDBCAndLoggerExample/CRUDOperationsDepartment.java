package com.apurv.JDBCAndLoggerExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class CRUDOperationsDepartment {
	
	static Logger logger = Logger.getLogger(CRUDOperationsDepartment.class);

	public void insertIntoDepartmentTable(Department department) {
		
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {
			statement.executeUpdate("INSERT INTO department VALUES ("+department.id+",'"+department.name+"')");
			logger.info("Department inserted successfully in database");
			
		} catch (SQLException e) {
			logger.error("Invalid details");		
		}

	}
	
	public void updateDepartment(Department department) {

		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement()) {
	
			statement.executeUpdate("update department set departmentName = '"+department.name+"' where departmentId= "+department.id+" ");
			logger.info("Department name updated to "+department.name+" for departmentId " +department.id);
		} catch (SQLException e) {
			logger.error("Invalid Department Id");		
		}

	}
	

	public void deleteDepartment(Department department) {

		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement =databaseConnection.createStatement()) {
			statement.executeUpdate("delete from department where departmentId= "+department.id+" ");
			logger.info("Department deleted for departmentId " +department.id);
			} catch (SQLException e) {
				logger.error("deleting invalid department");		
			}
		
	}

	public void readDepartment(Department department) {
	
		
		try (Connection databaseConnection = DriverManager.getConnection(DatabaseUtility.DATABASE_URL, DatabaseUtility.USERNAME, DatabaseUtility.PASSWORD);
				Statement statement = databaseConnection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from department where departmentId = "+department.getDepartmentId()+"");) {
			while(resultSet.next())
			{
				logger.info("Department details for department id "+department.id + " is " +new Department(resultSet.getInt("departmentId"), resultSet.getString("departmentName")));
			}
		
		} catch (SQLException e) {
			logger.error(e);		
		}
		
		
	}
	
	
	
	
}
