package la5.cs1120.wmich.edu;

import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler {
	
	/**
	 * will handle the FileNotFoundException error if it is thrown
	 * 
	 * @param e  The exception that was thrown
	 */
	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		System.out.println("This file was not found.");
	}

	/**
	 * will handle the PhoneNumberFormatException error if it is thrown and change it into the correct format
	 * 
	 * @param e  The exception that was thrown
	 */
	@Override
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		String phoneNum = e.getPhoneNumber();
		char[] phoneDigits = new char[10]; //store number with no ( ) -  -

		char[] inputChar = phoneNum.toCharArray(); // convert the raw input String into a char[]
		
		char[] finalChar = new char[14];

		int j = 0; //counter for phoneDigits array

		for(int i = 0; i< inputChar.length; i++){
		if(Character.isDigit(inputChar[i])){	//check if char is a digit
			phoneDigits[j] = inputChar[i];		//if it is a digit store that digit in phoneDigit[]
			j++;
		}
		}

			

		for(int i = 0; i < 14; i++){
			switch (i){

			case 0:
			finalChar[i] = '(';
			break;

			case 1:
			finalChar[i] = phoneDigits[0];
			break;

			case 2:
			finalChar[i] = phoneDigits[1];
			break;

			case 3:
			finalChar[i] = phoneDigits[2];
			break;

			case 4:
			finalChar[i] = ')';
			break;

			case 5:
			finalChar[i] = '-';
			break;

			case 6:
			finalChar[i] = phoneDigits[3];
			break;

			case 7:
			finalChar[i] = phoneDigits[4];
			break;

			case 8:
			finalChar[i] = phoneDigits[5];
			break;

			case 9:
			finalChar[i] = '-';
			break;

			case 10:
			finalChar[i] =  phoneDigits[6];
			break;

			case 11:
			finalChar[i] = phoneDigits[7];
			break;

			case 12:
			finalChar[i] = phoneDigits[8];
			break;

			case 13:
			finalChar[i] = phoneDigits[9];
			break;
			
			}
		}
		
		String phoneNumber = new String(finalChar);
		System.out.println(phoneNumber);
		
	}

	/**
	 * will handle the EmailAddressFormatException error if it is thrown and change it into the correct format
	 * 
	 * @param e  The exception that was thrown
	 */
	@Override
	public void handleEmailFormatException(EmailAddressFormatException e) {
		String email = e.getEmailAddress();
		char[] emailArray = email.toCharArray();
		for(int i = 0; i < email.length(); i++){
			if(Character.isLetter(emailArray[i])){
				if(Character.isUpperCase(emailArray[i])){
					emailArray[i] = Character.toLowerCase(emailArray[i]);
				}
			}
		}
		email = new String(emailArray);
		System.out.println(email);
		
	}

	/**
	 * Will handle the NameFormatException if it is thrown and change it into the correct format
	 * 
	 * @param e   The exception that was thrown
	 */
	@Override
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
