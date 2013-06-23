/**
 * @Author Amin Meyghani
 * Date: Feb.17.2011
 * Lab 7
 */
public interface LogEntry 
{
	/**
	 * toString method that prints out the content of the logBook
	 * @return the contents of the LogEntry as a String
	 */
	public String toString();
	
	/**
	 * getter method to get the month of in the logEntry 
	 * @return the month of the LogEntry as an int
	 */
	public int getMonth();
	/**
	 * getter method to get the day in the LogEntry
	 * @return the day of the LogEntry as an int
	 */
	public int getDay();
	/**
	 * Getter method that will return the year of the LogEntry as an int
	 * @return the year of the LogEntry as an int
	 */
	public int getYear();
	
}
