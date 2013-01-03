package views;
/**
 * {@code}
 * This class makes comparing two point objects in an ArrayList possible.
 * If the two values are equal, returned value is 0, if first point
 * is less than the second one then returned value is -1 and otherwise
 * it is 0.
 * @author Amin Meyghani
 * @version 1.0
 * 
 */
import java.util.Comparator;
import model.Point;

public class PointCompare implements Comparator<Point> {

	public int compare(Point a, Point b) {
		 
	        if (a.getXcoordinate() < b.getXcoordinate()) {
	            return -1;
	        }
	        else if (a.getXcoordinate() > b.getXcoordinate()) {
	            return 1;
	        }
	        else {
	            return 0;
	        }
	    }
	

}
