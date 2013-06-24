/*
 * @Author: Amin Meyghani
 * CS150-Lab5
 * @date: February/3/2011
 * @purpose: This class tests the Event class.
 */
public class EventTester {

	public static void main(String[] args) {

		Event event1 = new Event("World Around U meeting", 2011, 2, 4, 830,1200);
		Event event2 = new Event("Igloo Café", 2011, 2, 4, 930, 1200);
		Event event3 = new Event("Green House Jams", 2011, 2, 4, 930, 1200);
		Event event4 = new Event("Friday BBQ", 2011, 2, 5, 700, 1200);
		Event event5 = new Event("Handwriting Analysis", 2011, 2, 4, 1700, 1830);
		Event event6 = new Event("Karaoke Night", 2011, 3, 4, 2000, 2300);
		Event event7 = new Event("Soccer at Wold", 2010, 2, 5, 1230, 1430);
		Event event8 = new Event("Green House Sunday Brunch", 2011, 2, 6, 1700,1830);
		Event event9 = new Event("Superbowl Party", 2011, 2, 6, 1700, 1830);

		System.out.println("Compare event times:");
		compareEvents(event1, event2, -1);
		compareEvents(event2, event1, 1);
		System.out.println("Compare event days:");
		compareEvents(event3, event4, -1);
		compareEvents(event4, event3, 1);
		System.out.println("Compare event months:");
		compareEvents(event5, event6, -1);
		compareEvents(event6, event5, 1);
		System.out.println("Compare event years:");
		compareEvents(event7, event8, -1);
		compareEvents(event8, event7, 1);
		compareEvents(event8, event9, 0);
	}

	/*
	 * This method can compare either time, day, month or the year of two
	 * events.
	 */
	public static void compareEvents(Event firstEvent, Event secondEvent,int expectedResult) {
		int tester = firstEvent.compareTo(secondEvent);
		if (tester == 1) {
			System.out.println("Does " + firstEvent + " happen after "+ secondEvent + " ?");
		} else if (tester == -1) {
			System.out.println("Does " + firstEvent + " happen before "+ secondEvent + " ?");
		} else if (tester == 0) {
			System.out.println("Does " + firstEvent+ " happen at the same time as " + secondEvent + " ?");
		} else {
			System.out.println("Invalid output " + firstEvent + " and "+ secondEvent);
		}
		if (tester != expectedResult) {
			System.out.println("TEST FAILED. We expected to get "+ expectedResult + " but we got " + tester);
			System.out.println("------------------------");
		} else {
			System.out.println("Yes, it does. (TEST PASSED)");
			System.out.println("------------------------");

		}
	}
}
