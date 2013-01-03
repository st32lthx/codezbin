package views.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import views.ScatterPlotMainView;

public class TestScatterPlotMainView {

	@Test
	public void testScatterPlotMainView() {
		
		ScatterPlotMainView mainView = new ScatterPlotMainView();
		//TODO testing if the view was created by checking the windowWidth field.
		assertEquals(1004, mainView.getWindowWidth());
		assertEquals(697, mainView.getWindowHeight());
		
	}

	@Test
	public void testUpdate() {
		//TODO need to see if the update method is called.
		//TODO should there be a boolean in the mainwindow as a field that 
		//is set to true when update method is called???

		
	}

	@Test
	public void testToString() {
		ScatterPlotMainView mainView = new ScatterPlotMainView();
		assertEquals("I am MainView",mainView.toString() );
	}

}
