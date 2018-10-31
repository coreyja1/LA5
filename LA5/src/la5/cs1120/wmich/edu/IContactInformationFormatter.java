package la5.cs1120.wmich.edu;

public interface IContactInformationFormatter {
	void readContactInformation(String[] filePaths);
	void formatContactInformation(String fileName);
	void formatEmail(String email) throws EmailAddressFormatException;
	void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException;
	void formatName(String name) throws NameFormatException;

}
