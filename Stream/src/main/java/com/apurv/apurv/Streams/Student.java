package com.apurv.apurv.Streams;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	String name;
	int id;
	String skill;
	int marksInSkill;
	String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getMarksInSkill() {
		return marksInSkill;
	}

	public void setMarksInSkill(int marksInSkill) {
		this.marksInSkill = marksInSkill;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(String name, int id, String skill, int marksInSkill, String email) {
		super();
		this.name = name;
		this.id = id;
		this.skill = skill;
		this.marksInSkill = marksInSkill;
		this.email = email;
	}
	
	public static List<Student> getStudentList()
	{
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Ramesh", 1, "JAVA", 80, "ramesh@apurv.com"));
		students.add(new Student("Suresh", 2, ".NET", 70, "suresh@apurv.com"));
		students.add(new Student("Ganesh", 3, ".NET", 50, "ganesh@apurv.com"));
		students.add(new Student("Akash", 4, "JAVA", 85, "akash@apurv.com"));
		students.add(new Student("Naksh", 5, "SDET", 60, "naksh@apurv.com"));
		students.add(new Student("Raj", 6, ".NET", 75, "raj@apurv.com"));
		students.add(new Student("Shikhar", 7, "SDET", 90, "shikhar@apurv.com"));
		students.add(new Student("Dhir", 8, "SDET", 88, "dhir@apurv.com"));
		students.add(new Student("Prerak", 9, "SDET", 87, "prerak@apurv.com"));
		students.add(new Student("Jay", 10, "JAVA", 95, "jay@apurv.com"));
		
		return students;
	}

	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", skill=" + skill + ", marksInSkill=" + marksInSkill
				+ ", email=" + email + "]";
	}

}
