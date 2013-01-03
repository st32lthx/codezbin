package main;
import views.ScatterPlotMainView;

/**
 * {@code}
 * ScatterPlot is a GUI based application that enables users to create, save and
 * load scatter plots that are made from their data points. Users can input points one by
 * one. They can press the return key to connect or disconnect points.
 * Version 2.0 will enable users to put in series of points from window. It will also enable
 * users to user more hot keys on the keyboard to access different options of the ScatterPlot.
 * Documentation available at: http://meyghani.net/scatterPlot
 * 
 * @author Amin Meyghani
 * @version 1.0
 * 
 * 
 */
public class Main {
	public static void main(String[] args) {
		ScatterPlotMainView mainView = new ScatterPlotMainView(); mainView.setVisible(true);

	}
}
