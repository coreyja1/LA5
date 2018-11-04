package la5.cs1120.wmich.edu;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
	//the exception handler class that will be used
	FormatExceptionHandler FormatEx = new FormatExceptionHandler();
	
	@Override
	/**
	 * for each string in the input array will call formatContactInformation using each string as a parameter
	 * @param filePaths   The String array of filenames
	 */
	public void readContactInformation(String[] filePaths) {
		for (int i = 0; i < filePaths.length; i++) {
			formatContactInformation(filePaths[i]);
		}
	}

	@Override
	/**
	 * creates and reads a file from the input and calls methods for each line to check the formatting
	 * will throw FileNotFoundException if the file does not exist
	 * @param fileName   the File name passed by readContactInformation
	 */
	public void formatContactInformation(String fileName) {
		// TODO Auto-generated method stub
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			formatName(sc.nextLine());
			//this is the end of the name part, next lines can be for the other methods
			
			
			
			sc.close();
			//if file is not found will call formatEx to handle it
		} catch (FileNotFoundException e) {
			FormatEx.handleFileNotFoundException(e);
		}
	}

	
	  @Override public void formatEmail(String email) { 
	  //Auto-generated method stub
	  
	  }
	  
	  @Override public void formatPhoneNumber(String phoneNumber) { // TODO
	  //Auto-generated method stub
	  
	  }
	

	@Override
	/**
	 * This method takes a line from the input file and checks to see if it fits the correct name format
	 * @param name     The name from the file
	 */
	public void formatName(String name) {
		// TODO Auto-generated method stub
		try {
			String[] nameList = name.split(" ");
			boolean isCap;
			//iterates through the first and last name, if the first letter is not capitalized will throw NameFormatException
			for (int i = 0; i <nameList.length; i++) {
				isCap = (Character.isUpperCase(nameList[i].charAt(0)));
				
			if (isCap == false) {
					throw new NameFormatException(nameList);
			}
			//iterates through each character in the name, if any are capitilized will throw NameFormatException
			for (int j = 1; j < nameList[i].length(); j++) {
					char c = nameList[i].charAt(j);
					isCap = Character.isUpperCase(c);
					
					if (isCap == true) {
						throw new NameFormatException(nameList);
					}
				}
			}
			System.out.println(nameList[0] + " " + nameList[1]);
		
	}
		//If nameFormatException was thrown, will handle it with formatEx
		catch(NameFormatException e) {
		System.out.println("ERRRRRRRROR");
		FormatEx.handleNameFormatException(e);
	}
		
}
}
