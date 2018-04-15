package com.apurv.apurv.Streams;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import java.util.stream.Collectors;

public class StreamOperationsExample {
	

	static Scanner inputFromConsole = new Scanner(System.in);
	static List<Student> students = Student.getStudentList();
	
	public static void main(String[] args) {
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Enter Student Name To search:");
		String input = getInputString();		
		searchStudentByName(input);
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Enter skill to get students of that skill (JAVA|.NET|SDET):");
		input = getInputString();
		if(checkInput(input))
			filterStudentBasedOnSkills(input);
		else
			System.out.println("Invalid skill");
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Sorting Students based on marks:");
		sortStudentsBasedOnMarks();
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Sum of Marks of all students");
		sumOfMarksForAllStudents();
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Enter skill to get Sum of marks of students skill wise (JAVA|.NET|SDET):");
		input=getInputString();
		if(checkInput(input))
			System.out.println("Sum of Marks for "+input+" skill is " + sumOfMarksOfStudentsBaseOnSkill(input));
		else
			System.out.println("Invalid skill");
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Minimum and Maximum marks of students from entire list: ");
		System.out.println("Maximum:" );
		getMaximumMarks();
		System.out.println("Minimum:");
		getMinimumMarks();
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Enter marks to filter students greater than given Marks.Input Marks should be (< 100):");
		int inputNumber=getInputNumber();
		if(inputNumber >0 && inputNumber < 100)
			filterStudentBasedOnMarks(inputNumber);
		else
			System.out.println("Marks should be between 1 and 100");
		System.out.println("---------------------------------------------------------------------------------");
		
		
	}
	private static void filterStudentBasedOnMarks(int marks) {
		
		List<Student> result = students.stream().filter((student)->student.getMarksInSkill() > marks).collect(Collectors.toList());
		
		printList(result);

		
	}
	private static int getInputNumber() {
		
		int inputNumber = -1;
		try {
		 inputNumber = inputFromConsole.nextInt();
		}
		catch(NumberFormatException n)
		{
			System.out.println("Enter valid input");
		}
		
		return inputNumber;
	}
	private static boolean checkInput(String input) {
		return input.equalsIgnoreCase("JAVA") || input.equalsIgnoreCase(".NET") || input.equalsIgnoreCase("SDET");
				
	}
	
	private static void getMinimumMarks() {
		
		Optional<Student> answer=students.stream().min((studentOne,studentTwo)->studentOne.getMarksInSkill().compareTo(studentTwo.getMarksInSkill()));
		
		if(answer.isPresent())
			System.out.println(answer.get());
		
	}
	
	private static void getMaximumMarks() {
	
		Optional<Student> answer=students.stream().max((studentOne,studentTwo)->studentOne.getMarksInSkill().compareTo(studentTwo.getMarksInSkill()));
		
		if(answer.isPresent())
			System.out.println(answer.get());
	
	}
	
	private static int sumOfMarksOfStudentsBaseOnSkill(String skill) {
		
		int sumOfMarksForGivenSkill=students.stream()
				.filter(student -> skill.equalsIgnoreCase(student.getSkill()))
				.mapToInt(student -> student.getMarksInSkill())
				.sum();
		
		return sumOfMarksForGivenSkill;
		
	}
	
	private static int sumOfMarksForAllStudents() {

		return students.stream().mapToInt(student -> student.getMarksInSkill()).sum();		
	}
	private static void sortStudentsBasedOnMarks() {
		
		students.stream().sorted((parameterOne,parameterTwo)->parameterOne.getMarksInSkill().compareTo(parameterTwo.getMarksInSkill())).forEach(System.out::println);		
	}
	private static void filterStudentBasedOnSkills(String skill) {
		
		System.out.println("Students filtered On skill");
		List<Student> studentsForRequiredSkill=students.stream().filter(student -> skill.equalsIgnoreCase(student.getSkill())).collect(Collectors.toList());
		
		System.out.println(skill + " Students");
		printList(studentsForRequiredSkill);
		
	}
	private static void searchStudentByName(String studentName) {

		List<Student> student=students.stream().filter(s-> studentName.equalsIgnoreCase(s.getName())).collect(Collectors.toList());
		printList(student);
		
	}
	private static String getInputString()
	{
		String input = inputFromConsole.nextLine();
		return input;
	}
	
	private static void printList(List<Student> student) {
		
		if(student.isEmpty())
			System.out.println("No results");
		else
			student.stream().forEach(elementInList -> System.out.println(elementInList));		
	}
	
}