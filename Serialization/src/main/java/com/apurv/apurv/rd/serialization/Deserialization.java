package com.apurv.apurv.rd.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
	public Employee deserialize()
	{Employee employee = null;
		try(ObjectInputStream o =new ObjectInputStream(new FileInputStream("employee.txt"))) {
		 employee =(Employee)o.readObject();
		System.out.println("Object deSerialized succcessfully");
		
		
		} catch (IOException|ClassNotFoundException ex) {
			System.out.println("we are unable to find the file in specified part or facing problem in deserializing object!!");
		} 
		return employee;
		
		
}}
