
/**
 * Tests the logbook by filling it with various events and reminders.
 * 
 * @authors Chris Fernandes, Linda Almstead, Aaron Cass and ...
 * @version 10/20/2008
 */
public class Client
{
	static LogBook book = new LogBook(11, 2008);
    public static void main(String[] args)
    {
    	printEntries(11, 2008);
    	printEntries(11, 2011);
    	printEntries(3, 2007);
    }
//====================================================   
    /**
     * This method creates and print certain entries of the 
     * logBook depending on the month and year of the logBook.
     */
    private static void printEntries(int month, int year) {
    	LogBook book = new LogBook(month, year);
    	 Event e1 = new Event("world around u meeting", 2011, 11, 6, 1505, 1645);
         Event e2 = new Event("basketball game", 2008, 11, 7, 1600, 1800);
         Event e3 = new Event("hockey game", 2008, 11, 6, 1900, 2130);
         Event e4 = new Event("broomball", 2008, 11, 10, 2300, 2345);
         Reminder r1 = new Reminder("Election Day", "11/04/2008");
         Reminder r2 = new Reminder("Daylight Savings Time ends", "11/02/2008");
         Reminder r3 = new Reminder("Turkey Day!", "11/27/2008");
         book.insertEntry(e1);
         book.insertEntry(e2);
         book.insertEntry(e3);
         book.insertEntry(e4);
         book.insertEntry(r1);
         book.insertEntry(r2);
         book.insertEntry(r3);
         //changing the events start and time for the events 
         //that are schedule between the 5th and 7th of the month.
         for(int x=5; x<7; x++)
         {
         	if(book.getEntry(x) instanceof Event)
             {
             	Event e = (Event) book.getEntry(x);
             	e.setStart(1200);
             	e.setEnd(1300);
             }	
         }
         System.out.println(book);
         addRule();
    	}
   


/**
 * This method adds a separator.
 */
    private static void addRule() {
		System.out.println("-------------------");
	}
}
