package views.tests;

import static org.junit.Assert.*;

import model.ScatterPlotModel;

import org.junit.Test;

import views.ScatterPlotAxisView;

public class TestScatterPlotAxisView {

	@Test
	public void testScatterPlotAxisView() {
	}

	@Test
	public void testToString() {
		ScatterPlotAxisView axis = new ScatterPlotAxisView(new ScatterPlotModel());
		assertEquals("I am PlotAxisView as an observer ", axis.toString());
	}

	@Test
	public void testUpdate() {
		
		ScatterPlotAxisView axis = new ScatterPlotAxisView(new ScatterPlotModel());
		//TODO need to crate a fake object to mock the behavior. . . 
		
	}

	@Test
	public void testPaintGraphics() {
		//TODO need to crate a fake object to mock the behavior. . . 
	}

}
