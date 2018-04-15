package com.apurv.apurv.IOTasks;

import java.util.ArrayList;

public class WriteToFileMain {
	
public static void main(String[] args) {
		
		WriteToFile file = new WriteToFile();
		file.getFileName();
		file.createFile();
		ArrayList<String> fileContent=file.getFileContentFromUser();
		file.enterUserContentsToFile(fileContent);
		
	}

}
