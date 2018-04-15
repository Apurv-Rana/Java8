package com.apurv.apurv.IOTasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class StringOccurrencesMain {

	static BufferedReader inputFromConsole = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] commandLineArguments) {

		StringOccurences stringOccurences = new StringOccurences();
		if(lengthOfCommandLineArguments(commandLineArguments) == 2)
		{
			String filePath = commandLineArguments[0];
			String givenString = commandLineArguments[1];
			File file = new File(filePath);
			if(file.exists())
				System.out.println("Given String "+givenString +" occurs "+stringOccurences.getStringOccurencesFromFile(file,givenString)+" times");
			else
				System.out.println("File does not exist");
		}
		else
			System.out.println("Enter proper arguments");
	}

	private static int lengthOfCommandLineArguments(String[] commandLineArguments) {
		// TODO Auto-generated method stub
		return commandLineArguments.length;
	}
}
