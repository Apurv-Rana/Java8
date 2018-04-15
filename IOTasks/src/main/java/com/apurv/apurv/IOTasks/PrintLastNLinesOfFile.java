package com.apurv.apurv.IOTasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PrintLastNLinesOfFile {
	
	 String fileName;
	 int numberOfLinesToPrint=5;
	 ArrayList<String> allLinesInFile;
	 
	 public PrintLastNLinesOfFile(String fileName, int numberOfLinesToPrint) {
		 
		 this.fileName = fileName;
		 this.numberOfLinesToPrint = numberOfLinesToPrint;
		 
	 }
	 public PrintLastNLinesOfFile(String fileName) {

		 this.fileName = fileName;
	 }
	 
	 public void printLastNLines()
	 {
		 readEntireFile();
		 if(isFileNotEmpty())
		 {
			 int actualLines = allLinesInFile.size();
			 int i=actualLines-numberOfLinesToPrint;
			 if(i> 0)
			 {
				 i--;
				 while(i != actualLines)
				 {
					 System.out.println(allLinesInFile.get(i));
					 i++;
				 }
			 }
			 else
				 System.out.println("File Contains only "+actualLines+" lines");
		 }
		 else
			 System.out.println("File is Empty");
	 }
	 private boolean isFileNotEmpty() {
		// TODO Auto-generated method stub
		return allLinesInFile != null;
	}
	private void readEntireFile()
	 {
		 BufferedReader fileReader=null;
		 try {
			fileReader = new BufferedReader(new FileReader(fileName));
			while(true)
			{
				String line=fileReader.readLine();
				if(line == null)
					break;
				if(allLinesInFile == null)
					allLinesInFile = new ArrayList<String>();
				allLinesInFile.add(line);
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
