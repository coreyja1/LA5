package la5.cs1120.wmich.edu;

public class EmailAddressFormatException extends Exception {

	String email;

	public EmailAddressFormatException() {

	}

	public EmailAddressFormatException(String email) {
		this.email = email;
	}

	/**
	 * basic getter for the email address that caused the exception to be thrown
	 *
	 * @return email the email address that caused the exception
	 */
	public String getEmailAddress() {
		return this.email;
	}

}
