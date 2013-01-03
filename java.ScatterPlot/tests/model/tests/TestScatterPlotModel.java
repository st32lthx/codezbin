package model.tests;
/**
 * Tests for the scatterPlot Model
 */
import static org.junit.Assert.*;

import java.io.File;

import model.Point;
import model.ScatterPlotModel;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import views.ScatterPlotMainView;

public class TestScatterPlotModel {

	@Test
	public void testScatterPlotModel() {
		ScatterPlotModel model = new ScatterPlotModel();
		assertEquals(10, model.getMaxX(), 0.01);
		assertEquals(10, model.getMaxY(), 0.01);
		assertEquals("PlotTitle", model.getPlotTitle());
		assertEquals("x-axisLabel", model.getPlotXlabel());
		assertEquals("y-axisLabel", model.getPlotYlabel());
	}

	@Test
	public void testAddPoint() {

		ScatterPlotModel model = new ScatterPlotModel();
		model.addPoint(12.5, 45.5);
		Point a = (Point)model.getPointSet().get(0);
		
		assertEquals(12.5, a.getXcoordinate(), 0.01);
		assertEquals(45.5, a.getYcoordinate(), 0.01);
		
		//TODO testing the notifyObserversMethod !
	}

	@Test
	public void testToString() {
		ScatterPlotModel model = new ScatterPlotModel();
		String state = "";
		state+="Plot title: PlotTitle"+"\n"+
		"x-axis: x-axisLabel"+"\n"+
				"y-axis: y-axisLabel"+"\n"+
		"data set:  "+"\n"+
				"observers:  ";
		assertEquals(state,model.toString());
		//TODO test when an observer is added
		//TODO test when a point is added
		//TODO test when multiple is added
		
	}

	@Test
	public void testGetPlotTitle() {
		ScatterPlotModel model = new ScatterPlotModel();
		assertEquals("PlotTitle", model.getPlotTitle());
		//TODO test when the plot's name has changed.
		
	}

	@Test
	public void testGetPlotXlabel() {
		ScatterPlotModel model = new ScatterPlotModel();
		assertEquals("x-axisLabel", model.getPlotXlabel());
		//TODO test when the x-axis label has changed.
	}

	@Test
	public void testGetPlotYlabel() {
		ScatterPlotModel model = new ScatterPlotModel();
		assertEquals("y-axisLabel", model.getPlotYlabel());
		//TODO test when the y-axis label has changed.
	}

	@Test
	public void testSetPlotTitle() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.setPlotTitle("New Graph");
		assertEquals("New Graph", model.getPlotTitle());
		
	}

	@Test
	public void testSetPlotXlabel() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.setPlotXlabel("New x-axis label");
		assertEquals("New x-axis label", model.getPlotXlabel());
	}

	@Test
	public void testSetPlotYlabel() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.setPlotYlabel("New y-axis label");
		assertEquals("New y-axis label", model.getPlotYlabel());
	}

	@Test
	public void testSetMaxX() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.setMaxX(50.9);
		assertEquals(50.9, model.getMaxX(), 0.01);
		
	}

	@Test
	public void testSetMaxY() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.setMaxY(1000.89);
		assertEquals(1000.89, model.getMaxY(),0.01);
	}

	@Test
	public void testGetMaxX() {
		ScatterPlotModel model = new ScatterPlotModel();
		assertEquals(10.0, model.getMaxX(),0.01);
	}

	@Test
	public void testGetMaxY() {
		ScatterPlotModel model = new ScatterPlotModel();
		assertEquals(10.0, model.getMaxY(),0.01);
	}

	@Test
	public void testNotifyObservers() {
		//TODO need to check this again.
		ScatterPlotModel model = new ScatterPlotModel();
		model.addPoint(25.6, 34.5);
		//TODO ceate fake object... to test.
	
	}

	@Test
	public void testAddObserver() {

	//ScatterPlotMainView mainView = new ScatterPlotMainView();
	//mainView.setVisible(true);
	//TODO meed to create the mock object and click fine new button from the mainWindow
	//http://seamframework.org/Community/UnitTestingAnActionListener
		
	}

	@Test
	public void testRemoveObserver() {
		//TODO meed to create the mock object and click fine new button from the mainWindow

	}

	@Test
	public void testGetPointSet() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.addPoint(15.4, 13.6);
		model.getPointSet();
		assertEquals(1, model.getPointSet().size());
		
		
	}
	
	@Test
	public void testGetPointSetWithMultiplePoints() {
		ScatterPlotModel model = new ScatterPlotModel();
		
		for (int i = 0; i < 50; i++) {
			model.addPoint(i, i+1);
		}
		model.getPointSet();
		assertEquals(50, model.getPointSet().size());
		//TODO ?: test the content as well? the points per se
		
	}

	@Test
	public void testSave() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.save("test");
		File file = FileUtils.getFile("test.txt");
		boolean isFile = file.isFile();
		assertEquals(isFile, true);
		//TODO what if you want to save witht the file that already exist??
	}

	@Test
	public void testLoad() {
		ScatterPlotModel model = new ScatterPlotModel();
		model.save("newFile");
		
	}

}
