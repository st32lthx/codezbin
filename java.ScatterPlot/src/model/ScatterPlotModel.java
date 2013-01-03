package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

/**

 * {@code}
 * Description:  This class represents the model for the ScatterPlot
 * application. It contains information for any new ScatterPlot that 
 * is created. It contains the plot's title, x-axis labels and y-axis label.
 * Also, it contains the information for points.
 * In addition to that, it implements the observer patterns and has a list of
 * all the subscribers (the observers or the views). In this implementation there is
 * only one observer and that is the scatterPlotAxisView.
 * @author Amin Meyghani
 * @version 1.0
 
 */
public class ScatterPlotModel {

	
	private ArrayList<Observer> observers;
	private ArrayList<Point> 	pointSet;
	private 	String 			plotTitle;
	private 	String 			plotXlabel;
	private 	String 			plotYlabel;
	private 	double			maxX;
	private 	double			maxY;	
	
	
/**
 * Creates the model for the scatterPlot application.
 * It sets the title, the labels, creates the data set
 * container and observers and sets the scale of the 
 * plot. 
 */
public ScatterPlotModel(){
		
		plotTitle = "PlotTitle";
		plotXlabel = "x-axisLabel";
		plotYlabel = "y-axisLabel";
		pointSet = new ArrayList<Point>();
		observers = new ArrayList<Observer>();
		maxX = 10;
		maxY = 10;
		
	}
	




/*						
 * ---------------------
 * METHODS 
 * --------------------
 */	



	
/**adds a point to the set of points list.
 * Once the point is added, all the listeners of the plot
 * are notified. 
 * @param x double, the x-coordinate of the new point
 * @param y double, the y-coordinate of the new point
 */
	public void addPoint(double x, double y) {

		Point point = new Point(x, y);
		pointSet.add(point);
		notifyObservers();

	}





/**
 *  prints the status of the 
 * plot. It prints out the set of data points that
 * it contains, the plot's title, x and y labels.
 */
	public String toString() {

		String plotStatus = "Plot title: " + plotTitle + "\n" + "x-axis: "
				+ plotXlabel + "\n" + "y-axis: " + plotYlabel + "\n"
				+ "data set: " + printPointSet() + "\n" + "observers: "
				+ getObservernames();

		return plotStatus;

	}



/*						
 * ---------------------
 * HELPERS 
 * --------------------
 */	

	private String printPointSet() {
		String dataSet = " ";
		for (Point p : pointSet) {
			dataSet += (p.getXcoordinate() + " " + p.getYcoordinate()) + "\n";
		}
		return dataSet;
	}

	private String getObservernames() {
		String observerList = " ";
		int i = 0;
		for (Observer o : observers) {
			observerList += (observers.get(i)) + "\n";
			i++;
		}
		return observerList;
	}

/*						
 * ---------------------
 * SETTERS AND GETTERS 
 * --------------------
 */						

	/**
	 * gets the plotTitle name.
	 * 
	 * @return String, plot's title
	 */
	public String getPlotTitle() {
		return plotTitle;
	}


	/**
	 * gets the x-axis label of the plot.
	 * 
	 * @return String, the x-axis label.
	 */
	public String getPlotXlabel() {
		return plotXlabel;
	}

	/**
	 * gets the y-axis label.
	 * 
	 * @return string, the y-axis label of the plot.
	 */
	public String getPlotYlabel() {
		return plotYlabel;
	}

	/**
	 * sets the title of the plot.
	 * 
	 * @param newPlotTitle
	 *            : String, is the title to be given to the plot
	 */
	public void setPlotTitle(String newPlotTitle) {
		plotTitle = newPlotTitle;
		notifyObservers();
	}

	/**
	 * sets the x-axis label of the plot.
	 * 
	 * @param newPlotXlabel
	 *            is the label that is given to the x-axis of the plot.
	 */
	public void setPlotXlabel(String newPlotXlabel) {
		plotXlabel = newPlotXlabel;

		notifyObservers();
	}

/**Sets the ylabel of the plot.
 * @param newPlotYlabel is the label given to the y-axis label as a string.
 */
	public void setPlotYlabel(String newPlotYlabel) {
		plotYlabel = newPlotYlabel;
		notifyObservers();
	}

	/**
	 * Sets the maximum value that the x-axis can take.
	 * @param newMaxX (double) is the maximum value for the x-axis
	 */
	public void setMaxX(double newMaxX) {

		maxX = newMaxX;
		notifyObservers();
	}
/**
 * Sets the maximum value that the y-axis can take.
 * @param newMaxY (double) is the maximu value for the y-axis.
 */
	public void setMaxY(double newMaxY) {
		maxY = newMaxY;
		notifyObservers();
	}
/**
 * Returns the maximum value that the x-axis can show. (the x scale)
 * @return max (double) the maximum limit value for x-axis
 */
	public double getMaxX() {
		return maxX;
	}
/**
 * Returns the maximum limit value for the y-axis.
 * @return maxY (double) the maximum limit value for the y-axis
 */
	public double getMaxY() {
		return maxY;
	}

/*						
 * ---------------------
 * OBSERVABLE METHODS 
 * --------------------
 */	

	/**
	 * notifies all the observers of a change in the model.
	 */
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}

	/**
	 * adds an observer to the observers list of the model.
	 * 
	 * @param o
	 *            : Observer, the observer to be added.
	 */
	public void addObserver(Observer o) {
		observers.add(o);
	}

	/**
	 * removes an observer from the observers list of the model.
	 * 
	 * @param o
	 *            Observer, the observer to be removed.
	 */
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	/**
	 * Returns the set of points array list.
	 * 
	 * @return ArrayList, the set of points in an arrayList
	 */
	public ArrayList getPointSet() {
		return pointSet;
	}

/*						
 * ---------------------
 * SAVE LOAD 
 * --------------------
 */	
/**
 * Saves the information of the plot into a text file.
 */
	public void save(String filename) {

		System.out.println("saving:" + plotTitle + " ... ");
		try {
			File plotFile = new File(filename + ".txt");

			ArrayList<String> lines = new ArrayList<String>();
			lines.add(plotTitle);
			lines.add(plotXlabel);
			lines.add(plotYlabel);

			if (pointSet.size() > 0) {
				for (int i = 0; i < pointSet.size(); i++) {
					lines.add(pointSet.get(i).toString());
				}
			}
			lines.add("eof");
			FileUtils.writeLines(plotFile, lines);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("file saved!");
	}


/**
 * Loads the information of the file from text file.
 * @param filename is the name of the text file to be read from (example.txt)
 */
	public void load(String filename) {
		try {

			File file = new File(filename);
			System.out.println("loading . . ");
			plotTitle = FileUtils.readLines(file).get(0);
			plotXlabel = FileUtils.readLines(file).get(1);
			plotYlabel = FileUtils.readLines(file).get(2);
			boolean canRead = true;

			int i = 3;
			int j = 0;
			while (canRead == true) {
				if ((FileUtils.readLines(file).get(i).equals("eof"))) {
					canRead = false;
				}

				else if (!(FileUtils.readLines(file).get(j).equals("eof"))) {

					double xCoordinate = Double.parseDouble(FileUtils
							.readLines(file).get(i));
					double yCoordinate = Double.parseDouble(FileUtils
							.readLines(file).get(i + 1));
					addPoint(xCoordinate, yCoordinate);
					j = i + 2;

					i += 2;
				} else {
					canRead = false;
				}
			}

			notifyObservers();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("file loaded!");
	}




	
}
