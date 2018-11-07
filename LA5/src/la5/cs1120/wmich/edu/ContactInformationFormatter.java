package la5.cs1120.wmich.edu;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
	//the exception handler class that will be used
	FormatExceptionHandler FormatEx = new FormatExceptionHandler();
	
	/**
	 * for each string in the input array will call formatContactInformation using each string as a parameter
	 * @param filePaths   The String array of filenames
	 */
	@Override
	public void readContactInformation(String[] filePaths) {
		for (int i = 0; i < filePaths.length; i++) {
			formatContactInformation(filePaths[i]);
		}
	}
	
	/**
	 * creates and reads a file from the input and calls methods for each line to check the formatting,
	 * will throw FileNotFoundException if the file does not exist
	 * @param fileName   the File name passed by readContactInformation
	 */
	@Override
	public void formatContactInformation(String fileName) {
		// TODO Auto-generated method stub
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			
			while(sc.hasNext()){
			formatName(sc.nextLine());
			formatPhoneNumber(sc.nextLine());
			formatEmail(sc.nextLine());
			}
			
			sc.close();
			//if file is not found will call formatEx to handle it
		} catch (FileNotFoundException e) {
			System.out.println(fileName);
			FormatEx.handleFileNotFoundException(e);
		}
	}

	/**
	 * This method takes a line from the input file and checks to see if it fits the correct email format
	 * @param email     The email name from the file
	 */
	  @Override public void formatEmail(String email) { 
		  boolean correctFormat = true;
		  
		  try {
			 
			  char[] emailArray = email.toCharArray();
				for(int i = 0; i < email.length(); i++){
					if(Character.isLetter(emailArray[i])){
						if(Character.isUpperCase(emailArray[i])){
							correctFormat = false;
							throw new EmailAddressFormatException(email);
						}
						
					}
				}
				  
			  }catch(EmailAddressFormatException e){
				  FormatEx.handleEmailFormatException(e);
			  }
			if(correctFormat){
				System.out.println(email);
			}
	  
	  }
		/**
		 * This method takes a line from the input file and checks to see if it fits the correct phone number format
		 * @param phoneNumber     The phone number from the file
		 */
	  
	  @Override public void formatPhoneNumber(String phoneNumber) { // TODO
		  String regEx = "^\\((\\d{3})\\)[- ](\\d{3})[- ](\\d{4})$";
		  
		  try {
			if(phoneNumber.matches(regEx) == false){
				throw new PhoneNumberFormatException(phoneNumber);
			}else{
				System.out.println(phoneNumber);
			}
			  
		  }catch(PhoneNumberFormatException e){
			  FormatEx.handlePhoneNumberFormatException(e);
		  }
		
	  }
	
		/**
		 * This method takes a line from the input file and checks to see if it fits the correct name format
		 * @param name     The name from the file
		 */
	@Override
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
		FormatEx.handleNameFormatException(e);
	}
		
}
}
