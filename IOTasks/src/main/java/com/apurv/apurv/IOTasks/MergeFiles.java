package com.apurv.apurv.IOTasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeFiles {

	File firstFile;
	File secondFile;
	File mergeFile;
	
	public MergeFiles(String firstFileName,String secondFileName)
	{
		this.firstFile = new File(firstFileName);
		this.secondFile = new File(secondFileName);
	}
	
	public boolean fileExists(File fileToCheck)
	{
		return fileToCheck.exists();
	}
	
	public boolean mergeTwoFiles(String mergeFileName)
	{
		boolean mergeSucess = false;
		PrintWriter writerToMergeFile =null;
		BufferedReader firstFileReader=null;
		BufferedReader secondFileReader=null;
		
		if(askUserCommandIfMergeFileExists(mergeFileName))
			createNewFile(mergeFileName);
		if(fileExists(firstFile) && fileExists(secondFile))
		{
			try {
				 writerToMergeFile = new PrintWriter(mergeFile);
				 firstFileReader = new BufferedReader(new FileReader(firstFile)); 
				 secondFileReader = new BufferedReader(new FileReader(secondFile)); 
				
				String lineFromFile=null;
				while(( lineFromFile=firstFileReader.readLine())!= null)
					writerToMergeFile.println(lineFromFile);
				
				
				while(( lineFromFile=secondFileReader.readLine())!= null)
					writerToMergeFile.println(lineFromFile);
				
				mergeSucess=true;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			finally {
				writerToMergeFile.close();
				try {
					firstFileReader.close();
					secondFileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}  
		  		          
		}
		else
			System.out.println("Given File doesnot exist");
		
		return mergeSucess;
	}

	private boolean askUserCommandIfMergeFileExists(String mergeFileName) {
		// TODO Auto-generated method stub
		boolean answer = false;
		mergeFile = new File(mergeFileName);
		if(fileExists(mergeFile))
		{
			System.out.println("File Already Exists");
			System.out.println("do you still want to overwrite the file(Y|N):");
			Scanner scanner = new Scanner(System.in);
			String userCommand = scanner.next();
			
			if(userCommand.equals("Y"))
				answer = true;
			scanner.close();
		}
		return answer;
	}

	private void createNewFile(String mergeFileName) {
		// TODO Auto-generated method stub
		mergeFile = new File(mergeFileName+".txt");
		
		try {
			mergeFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	
}
