/**
 * An Event is a gathering that happens on a particular date.  
 * It has a defined name, starting time, and ending time.
 * 
 * @authors Chris Fernandes, Linda Almstead, and ...
 * @version 2/3/2004
 */
public class Event implements LogEntry
{
    private String name;    // name/description of event
    private int year;       // 4-digit year in which event occurs (e.g. 2004)
    private int month;      // number of month 1=Jan, 12=Dec
    private int day;        // day of the month
    private int startTime;  // time the event starts in 4-digit military time 
                            // (e.g. 1:15 PM is represented as 1315)
    private int endTime;    // time the event starts in military time 

    //constructor
    public Event(String event, int year, int month, int day, int start, int end)
    {
        this.name=event;
        this.year=year;
        this.month=month;
        this.day=day;
        this.startTime=start;
        this.endTime=end;
    }
    
    //returns the event as a printable String
    public String toString()
    {
        return name + "  " 
	    + month + "/" 
	    + day + "/" 
	    + year + "  " 
	    + startTime + "-" + endTime;
    }
    public int getMonth()
    {
    	return month;
    }
    
    public int getDay()
    {
    	return day;
    }
    
    public int getYear()
    {
    	return year;
    }
    /**
     * Give this event a new start time
     *
     * @param startTime the new start time
     */
    public void setStart(int startTime)
    {
    	this.startTime = startTime;
    }
    /**
     * Give this event a new end time
     *
     * @param endTime the new end time
     */
    public void setEnd(int endTime)
    {
    	this.endTime = endTime;
    }
}
