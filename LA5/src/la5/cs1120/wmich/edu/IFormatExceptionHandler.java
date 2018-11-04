package la5.cs1120.wmich.edu;

import java.io.FileNotFoundException;

public interface IFormatExceptionHandler {
	void handleFileNotFoundException(FileNotFoundException e);
	void handlePhoneNumberFormatException(PhoneNumberFormatException e);
	void handleEmailFormatException(EmailAddressFormatException e);
	void handleNameFormatException(NameFormatException e);

}
