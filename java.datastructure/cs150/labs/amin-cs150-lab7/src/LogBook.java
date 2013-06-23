/**
 * @Author Amin Meyghani
 * @Date: Feb.17.2011
 * @purpose: Lab 7
 */
public class LogBook {

	private int month;
	private int year;
	private LogEntry[] entries;

	public LogBook(int month, int year) {
		this.month = month;
		this.year = year;
		entries = new LogEntry[31];
	}
	/**
	 * This method inserts an entry(a reminder or an event) to the logBok.
	 * @param logEntry
	 * @return true if and only if an entry does not already exists and the month or the year
	 * of the entry do not match a given entry.
	 */
	public boolean insertEntry(LogEntry logEntry) {
		int day = logEntry.getDay();

		if (doesEntryAlreadyExist(day) || !doYearAndMonthMatch(logEntry)) {
			return false;
		} else {
			entries[day] = logEntry;
			return true;
		}
	}
	/**
	 * 
	 * @param day
	 * @return true if an entry with the same day of the month exists in the entry and 
	 * false otherwise. 
	 */
	private boolean doesEntryAlreadyExist(int day) {

		if (entries[day] != null) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * @param logEntry
	 * @return true iff the year and month of logEntry match the year and month
	 *         of this LogBook.
	 */
	private boolean doYearAndMonthMatch(LogEntry logEntry) {

		if (month == logEntry.getMonth() && year == logEntry.getYear()) {
			return true;
		} else {
			return false;
		}
	}
/**
 * This method returns an entry depending on the day of that entry.
 * @param day
 * @return if entry of a certain day exists, it will return it, otherwise
 * it will not return anything
 */
	public LogEntry getEntry(int day) {
		if (entries[day] == null) {
			return null;
		}
		return entries[day];
	}
/**
 * This method is the toStrin method that return all the entries of the logBook
 * as a single printable string.
 */
	public String toString() {
		String content = "(" + "The logBook entries for month " + month
				+ " and year " + year + ")" + "\n"+"\n";
		for(int i=0; i<entries.length; i++)
		{
			if(entries[i]!=null)
			{
				content+= "\n ";
				if(i<entries.length -1)
				{
					content += entries[i];
				}
				else
				{
					content += entries[i];
				}
			}
		}
		return content;
	}
}
