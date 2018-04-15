package com.apurv.apurv.IOTasks;

public class PrintFirstNLinesMain {
	
	public static void main(String[] commandLineArgument) {
		
		if(lengthOfCommandLineArguments(commandLineArgument) == 2)
		{
			String filePath = commandLineArgument[0];
			int numberOfLines = Integer.parseInt(commandLineArgument[1]);
			PrintFirstNLinesFromFile printFirstNLinesFromFile = new PrintFirstNLinesFromFile(filePath,numberOfLines);
			printFirstNLinesFromFile.printFirstNLines();
		}
		else if(lengthOfCommandLineArguments(commandLineArgument) == 1)
		{
			String filePath = commandLineArgument[0];
			PrintFirstNLinesFromFile printFirstNLinesFromFile = new PrintFirstNLinesFromFile(filePath);
			printFirstNLinesFromFile.printFirstNLines();
		}
		else
			System.out.println("Enter Proper Arguments");
		
	}
	private static int lengthOfCommandLineArguments(String[] commandLineArguments) {
		// TODO Auto-generated method stub
		return commandLineArguments.length;
	}
}
