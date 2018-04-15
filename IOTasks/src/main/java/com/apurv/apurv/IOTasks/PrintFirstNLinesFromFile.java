package com.apurv.apurv.IOTasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PrintFirstNLinesFromFile {
	
	 String fileName;
	 int numberOfLinesToPrint=5;
	 String firstNLines[];

	 public PrintFirstNLinesFromFile(String fileName, int numberOfLinesToPrint) {
		 
		 this.fileName = fileName;
		 this.numberOfLinesToPrint = numberOfLinesToPrint;
		 
	 }
	 public PrintFirstNLinesFromFile(String fileName) {

		 this.fileName = fileName;
	 }
	 
	 public void printFirstNLines()
	 {
		 readFirstNLines();
		 if(isFileNotEmpty())
		 {
			 int actualLines = firstNLines.length;
			 for(int i=0;i<actualLines;i++)
			 {
				 if(firstNLines[i] == null)
				 {
					 System.out.println("Only "+ i +" Lines in file");
					 break;
				 }
				 System.out.println(firstNLines[i]);
			 }
		 }
		 else
			 System.out.println("Empty File");
	 }
	 private boolean isFileNotEmpty() {
		// TODO Auto-generated method stub
		return firstNLines != null;
	}
	private void readFirstNLines()
	 {
		 BufferedReader fileReader=null;
		 try {
			fileReader = new BufferedReader(new FileReader(fileName));
			for(int i=0;i<numberOfLinesToPrint;i++)
			{
				String line=fileReader.readLine();
				if(line == null)
					break;
				if(firstNLines == null)
					firstNLines = new String[numberOfLinesToPrint];
				firstNLines[i]=line;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Enter valid file path and run again");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			if(fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	 }
		
	 

}
