package com.apurv.apurv.IOTasks;

public class MergeFileMain {
	
	public static void main(String[] commandLineArguments) {
		
		String fileOne = commandLineArguments[0];
		String fileTwo = commandLineArguments[1];
		String mergeFileName = commandLineArguments[2];
		MergeFiles files  = new MergeFiles(fileOne, fileTwo);
		boolean mergeSucess=files.mergeTwoFiles(mergeFileName);
		
		if(mergeSucess)
			System.out.println("File merged successfully");
	}

}
