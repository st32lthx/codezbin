package model;

/**
 * {@code}
 * This class represents a point object.
 * It contains information for point. That is the
 * x-y coordinates.
 * @author Amin Meyghani
 *@version 1.0
 */
public class Point {

	
	
	private double xCoordinate;
	private double yCoordinate;
	
	/**
	 * creates a point at point with x=0 and y=0
	 */
	public Point(){
		
		xCoordinate = 0;
		yCoordinate = 0;
	}

/**
 * Creates a point at coordinates x,y.
 * @param x is the x-coordinate of the point that is to be created of type double.
 * @param y is the y-coordinate of the point that is to be created of type double.
 */
public Point(double x, double y){
	
	xCoordinate = x;
	yCoordinate = y;
}



public String toString(){
	return xCoordinate+"\n"+yCoordinate;
}

/**
 * gets the x-coordinate of the point
 * @return double: the x-coordinate. 
 */
public double getXcoordinate() {
	return xCoordinate;
}




/**
 * gets the y-coordinate of the point
 * @return double: the y-coordinate. 
 */
public double getYcoordinate() {
	return yCoordinate;
}


}
