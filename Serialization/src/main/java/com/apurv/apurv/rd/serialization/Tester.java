package com.apurv.apurv.rd.serialization;

public class Tester {
	public static void main(String[] args) {
		Employee employee = new Employee(552968,"Apurv","Male");
Serialization serialization = new Serialization();
serialization.serialize(employee);
Deserialization deserialization = new Deserialization();
Employee employee1 = deserialization.deserialize();
System.out.println(employee1);
	}
}
