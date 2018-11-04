package la5.cs1120.wmich.edu;

import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler {

	@Override
	/**
	 * will handle the FileNotFoundException error if it is thrown
	 */
	public void handleFileNotFoundException(FileNotFoundException e) {
		// TODO Auto-generated method stub
		System.out.println("This file was not found.");
	}

	@Override
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEmailFormatException(EmailAddressFormatException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Will get the full name from the exception that was thrown and will format the first name by making 
	 * the string lowercase, will then make the first character uppercase and add it to
	 * the finished string. repeat for the last name
	 * 
	 * @param e   The exception that was thrown
	 */
	public void handleNameFormatException(NameFormatException e) {
		// TODO Auto-generated method stub
		String[] fullName = e.getName();
		String finishedName;
		String name = fullName[0].toLowerCase();
		char firstLetter = Character.toUpperCase(name.charAt(0));
		
		finishedName = firstLetter + name.substring(1) + " ";
		name = fullName[1].toLowerCase();
		firstLetter = Character.toUpperCase(name.charAt(0));
		finishedName = finishedName + firstLetter + name.substring(1);
		System.out.println(finishedName);
	}

}
