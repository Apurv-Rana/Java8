package com.apurv.apurv.IOTasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringOccurences {

	static BufferedReader inputFromConsole = new BufferedReader(new InputStreamReader(System.in));

	int getStringOccurencesFromFile(File file, String givenString) {
		// TODO Auto-generated method stub

		int stringOccurences = 0;

		BufferedReader fileReader = null ;
		try {
			fileReader= new BufferedReader(new FileReader(file));

			String lineOfFile = null;
			while((lineOfFile=fileReader.readLine()) != null)
			{
				String wordsOfLine[] = lineOfFile.split(" ");
				int lengthOfLineInWords = wordsOfLine.length;
				for(int i=0;i<lengthOfLineInWords;i++)
				{
					if(wordsOfLine[i].equals(givenString))
						stringOccurences++;
				}
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
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return stringOccurences;
	}

}
