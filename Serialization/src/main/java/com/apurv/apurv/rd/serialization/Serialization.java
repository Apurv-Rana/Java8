

	package com.apurv.apurv.rd.serialization;

	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectOutputStream;

	public class Serialization {
		
		public void serialize(Employee employee)
		{
			try(ObjectOutputStream o =new ObjectOutputStream(new FileOutputStream("employee.txt"))) {
			o.writeObject(employee);
			System.out.println("Object Serialized succcessfully");
			} catch (FileNotFoundException e) {
				System.out.println("we are unable to find the file in specified part!!");
			} catch (IOException e) {
				System.out.println("unable to seriablize object");
			}
			
		}
		
		
		

	}


