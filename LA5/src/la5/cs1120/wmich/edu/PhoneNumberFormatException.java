package la5.cs1120.wmich.edu;

public class PhoneNumberFormatException extends Exception {

	String phoneNum;

	public PhoneNumberFormatException() {

	}

	public PhoneNumberFormatException(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * basic getter for the phone number that caused the exception to be thrown
	 * 
	 * @return name the number that caused the exception
	 */
	public String getPhoneNumber() {
		return this.phoneNum;
	}

}
