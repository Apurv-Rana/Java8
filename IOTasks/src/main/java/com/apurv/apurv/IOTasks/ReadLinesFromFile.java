package com.apurv.apurv.IOTasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadLinesFromFile {
	
	void printFileLinesContainingGivenString(ArrayList<String> fileLinesContainingGivenString) {
		// TODO Auto-generated method stub
		
		if(fileLinesContainingGivenString != null)
		{
			if(fileLinesContainingGivenString.size() != 0)
			{
				for(String lineOfFile : fileLinesContainingGivenString)
					System.out.println(lineOfFile);
			}
			else
				System.out.println("No file line contains given string");
				
		}
		else
			System.out.println("File is Empty");
	}

	ArrayList<String> getLinesContainingGivenStringFromFile(File file, String givenString) {
		// TODO Auto-generated method stub
				
		ArrayList<String> fileLinesContainingGivenString = null;
		BufferedReader fileReader = null ;
		try {
			fileReader= new BufferedReader(new FileReader(file));
			
			String lineOfFile = null;
			while((lineOfFile=fileReader.readLine()) != null)
			{
				if(fileLinesContainingGivenString == null)
					fileLinesContainingGivenString = new ArrayList<String>();
				if(lineOfFile.contains(givenString))
					fileLinesContainingGivenString.add(lineOfFile);
					
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fileLinesContainingGivenString;
	}



}