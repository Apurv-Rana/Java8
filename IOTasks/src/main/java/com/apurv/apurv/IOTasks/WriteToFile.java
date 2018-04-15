package com.apurv.apurv.IOTasks;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteToFile {

	 static Scanner inputFromConsole = new Scanner(System.in);
	 String fileName;
	
	

	 void enterUserContentsToFile(ArrayList<String> fileContent) {
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
			if(fileContent != null)
			{
				for(String stringToWrite : fileContent)
					writer.println(stringToWrite);
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(writer != null)
				writer.close();
		}
		
	}

	 ArrayList<String> getFileContentFromUser() {
		// TODO Auto-generated method stub
		
		ArrayList<String> strings = null;
		String inputString = "";
		System.out.println("Enter File Content:");
		System.out.println("Type # to Exit");
		while(inputFromConsole.hasNext() )
		{
			inputString = inputFromConsole.nextLine();
			if(inputString.equals("#"))
				break;
			else if(strings == null)
				strings = new ArrayList<String>();
			
			strings.add(inputString);
		}
		
		return strings;
	}

	void createFile() {
		// TODO Auto-generated method stub
		File file = new File(fileName);
		
		if(fileDoesNotExist(file))
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	boolean fileDoesNotExist(File file) {
		// TODO Auto-generated method stub
		return !file.exists();
	}

	void getFileName() {
		// TODO Auto-generated method stub
		System.out.println("Enter File Name:");
		fileName = inputFromConsole.next();
		fileName+=".txt";
		
	}
	
}
