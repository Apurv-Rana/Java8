package com.apurv.apurv.IOTasks;

import java.io.File;
import java.util.ArrayList;

public class ReadLinesFromFileMain {

	public static void main(String[] commandLineArguments) {

		ReadLinesFromFile readLinesFromFile = new ReadLinesFromFile();
		if(lengthOfCommandLineArguments(commandLineArguments) == 2)
		{
			String filePath = commandLineArguments[0];
			File file = new File(filePath);
			if(file.exists())
			{			
				String givenString = commandLineArguments[1];
				ArrayList<String> fileLinesContainingGivenString=readLinesFromFile.getLinesContainingGivenStringFromFile(file,givenString);
				readLinesFromFile.printFileLinesContainingGivenString(fileLinesContainingGivenString);
			}
			else
				System.out.println("Enter correct path to file and run again");
		}
		else
			System.out.println("Enter proper Arguments");
		
	}
	private static int lengthOfCommandLineArguments(String[] commandLineArguments) {
		// TODO Auto-generated method stub
		return commandLineArguments.length;
	}
}
