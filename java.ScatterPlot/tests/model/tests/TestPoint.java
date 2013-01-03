package model.tests;
/**
 * Testing the point class.
 */
import static org.junit.Assert.*;

import model.Point;

import org.junit.Test;

public class TestPoint {

	@Test
	public void testPoint() {
		Point point = new Point();
		assertEquals(0.0,point.getXcoordinate(),0.001);
		assertEquals(0.0, point.getYcoordinate(),0.01);
		
		
	}
	

	@Test
	public void testNonDefaultPoint() {
		Point point = new Point(34.5, 45.5);
		assertEquals(34.5,point.getXcoordinate(),0.001);
		assertEquals(45.5, point.getYcoordinate(),0.01);
		
		
	}

	

	@Test
	public void testToString() {
		Point point = new Point(43,25);
		String state = "43.0"+"\n"+"25.0";
		assertEquals(state, point.toString());
	}

	@Test
	public void testGetXcoordinate() {
		Point point = new Point(12,32);
		assertEquals(12.0, point.getXcoordinate(),0.01);
	}

	@Test
	public void testGetYcoordinate() {
		Point point = new Point(12,44);
		assertEquals(44.0, point.getYcoordinate(),0.01);
	}

}
