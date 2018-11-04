package la5.cs1120.wmich.edu;

public class NameFormatException extends Exception {
	String[] name;
	public NameFormatException() {
		
	}
	public NameFormatException(String[] name) {
		this.name=name;
}
	/**
	 * basic getter for the full name that caused the exception to be thrown
	 * @return name    the name that caused the exception
	 */
	public String[] getName(){
		return name;
	}
}