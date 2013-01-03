package views;
/**
 * {@code}

 * data Jan.14.2012
 * This class represents the main view of the application. This is the main view
 * that creates the main frame of the application that consists of a menu bar with
 * file and help tabs. Under file users can create new plots, load and save files
 * and exit the application. Under the help menu users can learn about the application
 * itself.
 * 
 * When user creates a new plot, a new tabbed window opens that contains the plot. 
 * Once this view is created users can put in points and view the scatter plot. 
 * (more description can be seen in ScatterPlotAxisView.java)
 * @author Amin Meyghani
 * @version 1.0
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import model.Observer;
import model.ScatterPlotModel;


public class ScatterPlotMainView extends JFrame implements Observer {
	
	private 	JPanel 			backGroundContainer;
	private		JPanel			plottingRegion;
	private 	JPanel 			tabbedPanelContainer;
	private		JTabbedPane 	tabbedPane;
	private     int             windowWidth;
	private     int             windowHeight;


	public ScatterPlotMainView() {
		windowWidth = 1004;
		windowHeight = 697;
		setResizable(false);
		initiateMainViewComponents();
	}
	
	/*						
	 * ---------------------
	 * METHODS 
	 * --------------------
	 */	
	/*
	 * TODO want to know how i can have the save and load options in the main frame??
	 * @see model.Observer#update()
	 * that is why I have written the other view that is opened when you click save.
	 */

	public void update() {
		repaint();
		//TODO: should this be used somehow? I am not adding this as an observer!
		
	}
	
	public String toString(){
		
		return  "I am MainView";
	}
	
	/*						
	 * ---------------------
	 * HELPERS 
	 * --------------------
	 */	
	
	
	private void initiateMainViewComponents() {

		createApplicationFrame();
		createController(createMenuItems());
		createNewTabbedPlot();

	}
		
	
	private void createApplicationFrame() {
	
		setTitle("ScatterPlot | Version 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1004, 766);
		setLocationRelativeTo(null);
		backGroundContainer = new JPanel();
		backGroundContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		backGroundContainer.setLayout(new BorderLayout(0, 0));
		setContentPane(backGroundContainer);
		tabbedPanelContainer = new JPanel();
		tabbedPanelContainer.setLayout(new BorderLayout());
		getContentPane().add(tabbedPanelContainer);
		tabbedPane = new JTabbedPane();
	}


	private void createNewTabbedPlot() {
		ScatterPlotModel model = new ScatterPlotModel();
		plottingRegion = new ScatterPlotAxisView(model);
		//TODO does this have to be an instance variable i mean the model.
		tabbedPane.addTab("new plot " + tabbedPane.getTabCount(),
				plottingRegion);
		tabbedPanelContainer.add(tabbedPane, BorderLayout.CENTER);

		model.addObserver((Observer) plottingRegion);
	}
	

	private JMenuItem createMenuItems() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menuFile = new JMenu("File");
		menuFile.setIcon(new ImageIcon(ScatterPlotMainView.class
				.getResource("/resources/file.png")));
		menuBar.add(menuFile);

		JMenuItem fileCreateNewPlot = new JMenuItem("Create New Plot");

		fileCreateNewPlot.setIcon(new ImageIcon(ScatterPlotMainView.class
				.getResource("/resources/addFile.png")));
		menuFile.add(fileCreateNewPlot);

		JMenu menuHelp = new JMenu("Help");
		menuHelp.setIcon(new ImageIcon(ScatterPlotMainView.class
				.getResource("/resources/stat.png")));
		menuBar.add(menuHelp);

		JMenuItem helpAboutScatterPlot = new JMenuItem("About ScatterPlot");
		helpAboutScatterPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new ScatterPlotAboutView();

			}
		});
		menuHelp.add(helpAboutScatterPlot);

		JMenuItem helpHowTo = new JMenuItem("How to");
		helpHowTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ScatterPlotHowToView();
			}
		});
		menuHelp.add(helpHowTo);

		return fileCreateNewPlot;

	}
	
	
	/*						
	 * ---------------------
	 * CONTROLLERS 
	 * --------------------
	 */	
	
	
	private void createController(JMenuItem fileCreateNewPlot) {
		fileCreateNewPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewTabbedPlot();
			}
		});
	}


	/*						
	 * ---------------------
	 * GETTERS 
	 * --------------------
	 */
	/**
	 * gets the width of this window.
	 * @return
	 */
	public int getWindowWidth(){
		return windowWidth;
	}
	/**
	 * gets the window heigt.
	 * @return windowHeight
	 */
	public int getWindowHeight(){
		return windowHeight;
	}
	

	
	

}
