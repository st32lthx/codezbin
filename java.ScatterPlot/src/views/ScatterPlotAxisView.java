package views;
/**
 * {@code}
 * This class represents the view that contains plot. 
 * All the interactions with the plot take place here.
 * @author Amin Meyghani
 * @version 1.0
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import model.Observer;
import model.Point;
import model.ScatterPlotModel;

public class ScatterPlotAxisView extends JPanel implements Observer {

	private 	int 				windowWidth;
	private 	int					windowHeight;
	private 	final int		 	plotRegionWidth = 800;
	private 	final int			plotRegionHeight = 550;
	

	private JTextField xCoordinateTextField;
	private JTextField yCoordinateTextField;
	private ScatterPlotModel scatterPlotModel;
	private JButton btnAddPoint;
	private JButton btnConnectPoints;
	private JButton btnPlotStatus;
	private JButton editPlotButton;
	private JTextField plotTitleTextField;
	private JTextField xLabelTextField;
	private JTextField yLabelTextField;
	private JTextField maxXValField;
	private JTextField maxYValField;
	private JButton saveButton;
	private JButton loadButton;
	private JTextField saveField;
	private JTextField loadField;
	private boolean canConnect;

	
	
	public ScatterPlotAxisView(ScatterPlotModel model) {
		
		scatterPlotModel = model;
		initializeLayout();
		makeButtonsControllers();
		canConnect = false;

	}
	
	
	/*						
	 * ---------------------
	 * METHODS 
	 * --------------------
	 */	

	

	/**
	 * Prints the identity of the this view.
	 */
	public String toString() {
		String id = "I am PlotAxisView as an observer ";
		return id;

	}
	
	
	/**
	 * Updates the view (renders the current state of the model)
	 */
	public void update() {

		repaint();
	}
	

	
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.WHITE);
		drawGrid(g);
		drawAxis(g);
		drawLabels(g);
		handleDrawingLines(g);

	}
	
	
	
	/*						
	 * ---------------------
	 * HELPER METHODS 
	 * --------------------
	 */	

	


	/*						
	 * ---------------------
	 * PAINT HELPERS 
	 * --------------------
	 */	

	private void drawGrid(Graphics g) {
		g.setColor(new Color(185, 185, 185));

		for (int x = 0; x <= windowWidth; x += 20)
			g.drawLine(x, 0, x, windowWidth - 250);
		for (int y = 0; y <= windowHeight - 250; y += 20)
			g.drawLine(0, y, windowHeight, y);
		g.setColor(Color.black);
	}

	private void drawPlotTitle(Graphics g, String newPlotTitle) {

		g.drawString(newPlotTitle, 300, 549);
	}

	private void drawPlotXaxisLabel(Graphics g, String newPlotXaxisLabel) {

		g.drawString(newPlotXaxisLabel, 698, 315);
	}

	private void drawPlotYAxisLabel(Graphics g, String newPlotYaxisLabel) {

		g.drawString(newPlotYaxisLabel, 407, 15);
	}

	private void drawAxis(Graphics g) {
		drawXaxis(g);
		drawYaxis(g);
	}

	private void drawXaxis(Graphics g) {

		g.drawLine(0, (plotRegionHeight + 50) / 2, windowWidth,
				(plotRegionHeight + 50) / 2);
	}

	private void drawYaxis(Graphics g) {
		g.drawLine(windowWidth / 2, 0, windowWidth / 2, windowHeight - 250);
	}

	private void drawLabels(Graphics g) {
		drawPlotTitle(g,scatterPlotModel.getPlotTitle());
		drawPlotXaxisLabel(g, scatterPlotModel.getPlotXlabel());
		drawPlotYAxisLabel(g, scatterPlotModel.getPlotYlabel());
		g.drawString(Double.toString(scatterPlotModel.getMaxX()), plotRegionWidth-30, plotRegionHeight/2+15 );
		g.drawString(Double.toString(-scatterPlotModel.getMaxX()), 0, plotRegionHeight/2+15 );
		g.drawString(Double.toString(scatterPlotModel.getMaxY()), plotRegionWidth/2-30, 15 );
		g.drawString(Double.toString(-scatterPlotModel.getMaxY()), plotRegionWidth/2-40, plotRegionHeight-20 );
		
	}


	private void handleDrawingLines(Graphics g) {
		if(scatterPlotModel.getPointSet().size()>0){
			
			
			if (canConnect == true) {

				ArrayList<Point> points = new ArrayList<Point>();
				points = scatterPlotModel.getPointSet();

				if (points.size() >= 2) {

					Collections.sort(points, new PointCompare());

				}
				
			for (int i = 0; i < points.size()-1; i++) {
					
					double x1=((Point)scatterPlotModel.getPointSet().get(i)).getXcoordinate();
					double y1=((Point)scatterPlotModel.getPointSet().get(i)).getYcoordinate();
					
					double x2=((Point)scatterPlotModel.getPointSet().get(i+1)).getXcoordinate();
					double y2=((Point)scatterPlotModel.getPointSet().get(i+1)).getYcoordinate();
					
					((Graphics2D) g).draw(new Line2D.Double(

					x1 * ((plotRegionWidth / 2) / scatterPlotModel.getMaxX())
							+ plotRegionWidth / 2,

					-y1 * ((plotRegionHeight / 2) / scatterPlotModel.getMaxX())
							+ plotRegionHeight / 2,

					x2 * ((plotRegionWidth / 2) / scatterPlotModel.getMaxX())
							+ plotRegionWidth / 2,

					-y2 * ((plotRegionHeight / 2) / scatterPlotModel.getMaxY())
							+ plotRegionHeight / 2)

					);
				}
			}
			
			
			for (int i = 0; i < scatterPlotModel.getPointSet().size(); i++) {
				Point a = (Point) scatterPlotModel.getPointSet().get(i);
				double x = a.getXcoordinate();
				Point b = (Point) scatterPlotModel.getPointSet().get(i);
				double y = a.getYcoordinate();
				((Graphics2D) g).draw(new Rectangle2D.Double(x
						* ((plotRegionWidth / 2) / scatterPlotModel.getMaxX())
						+ plotRegionWidth / 2, -y
						* ((plotRegionHeight / 2) / scatterPlotModel.getMaxY())
						+ plotRegionHeight / 2, 3, 3));
			}
		}
	}

/*						
 * ---------------------
 * FRAME HELPERS
 * --------------------
 */	
	private void initializeLayout() {
		setBackground(Color.GRAY);
		windowWidth = 800;
		windowHeight = 800;

		setSize(996, 650);

		setLayout(null);

		JLabel inputXlabel = new JLabel("x");
		inputXlabel.setBounds(834, 109, 15, 21);
		add(inputXlabel);

		JLabel inputYlabel = new JLabel("y");
		inputYlabel.setBounds(921, 109, 15, 21);
		add(inputYlabel);

		xCoordinateTextField = new JTextField();
		xCoordinateTextField.setBounds(802, 77, 70, 28);
		add(xCoordinateTextField);
		makeButtons();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(809, 223, 160, 12);
		add(separator);

	}

	private void makeButtons() {
		btnAddPoint = new JButton("add Point");

		addPointController();

		btnAddPoint.setBounds(821, 39, 117, 29);
		add(btnAddPoint);

		yCoordinateTextField = new JTextField();
		yCoordinateTextField.setColumns(10);
		yCoordinateTextField.setBounds(889, 77, 70, 28);
		add(yCoordinateTextField);

		btnConnectPoints = new JButton("connect points");

		btnConnectPoints.setBounds(810, 183, 138, 28);
		add(btnConnectPoints);

		btnPlotStatus = new JButton("Print Status");

		btnPlotStatus.setBounds(821, 142, 117, 29);
		add(btnPlotStatus);

		editPlotButton = new JButton("edit plot");

		editPlotButton.setBounds(434, 566, 117, 57);
		add(editPlotButton);

		saveButton = new JButton("save plot");
		saveButton.setBounds(649, 563, 117, 29);
		add(saveButton);

		loadButton = new JButton("load plot");
		loadButton.setBounds(805, 563, 117, 29);
		add(loadButton);
	}

/*						
 * ---------------------
 * CONTROLLERS 
 * --------------------
 */	

	
	private void makeButtonsControllers() {
		
		

		btnConnectPoints.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ENTER) {
					if (canConnect == true) {
						canConnect = false;
					} else if (canConnect == false) {
						canConnect = true;
					}

					repaint();

				} else {
					return;
				}
			}

		});
		
		btnConnectPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (canConnect == true) {
					canConnect = false;
				} else if (canConnect == false) {
					canConnect = true;
				}

				repaint();

			}
		});
		
		
		

		btnPlotStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ScatterPlotViewPrintStatus statusView = new ScatterPlotViewPrintStatus();
				statusView.run((scatterPlotModel.toString()));

			}
		});

		
		editPlotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String newXLabel = xLabelTextField.getText();
				String newYLabel = yLabelTextField.getText();

				String newPlotTitle = plotTitleTextField.getText();

				scatterPlotModel.setPlotTitle(newPlotTitle);
				scatterPlotModel.setPlotXlabel(newXLabel);
				scatterPlotModel.setPlotYlabel(newYLabel);

				xLabelTextField.setText(" ");
				yLabelTextField.setText(" ");
				plotTitleTextField.setText(" ");

			}
		});
	
		
		makeFieldsAndLabels();
		
		JButton btnSetScale = new JButton("set scale");
		btnSetScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  scatterPlotModel.setMaxX(Double.parseDouble(maxXValField.getText()));
				  scatterPlotModel.setMaxY(Double.parseDouble(maxYValField.getText()));
				maxXValField.setText(" ");
				maxYValField.setText(" ");
				
				
			}
		});

		
		btnSetScale.setBounds(819, 324, 117, 29);
		add(btnSetScale);

		

		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				scatterPlotModel.save(saveField.getText());
				saveField.setText(" ");
			}
		});
		

		
		
		
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scatterPlotModel.load(loadField.getText());
			}
		});
		

		

	}

	
	private void makeFieldsAndLabels() {
	
		JLabel setPlotTitleLabel = new JLabel("set plot title");
		setPlotTitleLabel.setBounds(35, 566, 77, 21);
		add(setPlotTitleLabel);

		JLabel setXaxisLabel = new JLabel("set x-axis label");
		setXaxisLabel.setBounds(35, 597, 117, 21);
		add(setXaxisLabel);

		JLabel setYaxisLabel = new JLabel("set y-axis label");
		setYaxisLabel.setBounds(35, 629, 117, 21);
		add(setYaxisLabel);

		plotTitleTextField = new JTextField();
		plotTitleTextField.setBounds(164, 562, 236, 23);
		add(plotTitleTextField);
		plotTitleTextField.setColumns(10);

		xLabelTextField = new JTextField();
		xLabelTextField.setColumns(10);
		xLabelTextField.setBounds(164, 595, 236, 23);
		add(xLabelTextField);

		yLabelTextField = new JTextField();
		yLabelTextField.setColumns(10);
		yLabelTextField.setBounds(164, 627, 236, 23);
		add(yLabelTextField);

		JLabel maxXvalLabel = new JLabel("max x-value");
		maxXvalLabel.setBounds(802, 255, 85, 21);
		add(maxXvalLabel);

		JLabel maxYValLabel = new JLabel("max y-value");
		maxYValLabel.setBounds(802, 288, 85, 21);
		add(maxYValLabel);

		maxXValField = new JTextField();
		maxXValField.setBounds(899, 251, 70, 28);
		add(maxXValField);
		maxXValField.setColumns(10);

		maxYValField = new JTextField();
		maxYValField.setColumns(10);
		maxYValField.setBounds(899, 284, 70, 28);
		add(maxYValField);
		
		saveField = new JTextField();
		saveField.setColumns(10);
		saveField.setBounds(643, 595, 134, 28);
		add(saveField);

		loadField = new JTextField();
		loadField.setColumns(10);
		loadField.setBounds(802, 593, 134, 28);
		add(loadField);
}

	
	private void addPointController() {
		btnAddPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(xCoordinateTextField.getText().contains("a"))) {

				scatterPlotModel.addPoint(Double.parseDouble(xCoordinateTextField.getText()),Double.parseDouble(yCoordinateTextField.getText()));
				
					xCoordinateTextField.setText(" ");
					yCoordinateTextField.setText(" ");

					System.out.println("point was added");

				} else {
					return;
				}
			}

		});

	}
	
	/*						
	 * ---------------------
	 * GETTERS 
	 * --------------------
	 */	
	


	
}