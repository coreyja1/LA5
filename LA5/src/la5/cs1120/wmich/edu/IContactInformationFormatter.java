package la5.cs1120.wmich.edu;

public interface IContactInformationFormatter {
	void readContactInformation(String[] filePaths);
	/*read contact information from a list of files given the file paths*/
	void formatContactInformation(String fileName);
	/*format the contact information in one file*/
	void formatEmail(String email) throws EmailAddressFormatException;
	/*format one email address*/
	void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException; /*Format one phone number*/
	void formatName(String name) throws NameFormatException;
	/*format one name*/

}
