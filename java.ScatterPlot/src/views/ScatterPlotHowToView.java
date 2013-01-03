/**
 
 * {@code}
 * Description: This class represents a dialog box that appears
 * when users press the about item under the about menu item
 * in the menu toolbar. It simply prints out the name 
 * of the program, the author and the version.
 * @author Amin Meyghani
 * @version 1.0
 */
package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class ScatterPlotHowToView extends JDialog {

	
	private final JPanel wrapper = new JPanel();
	private JButton okButton;
	private JPanel mainContentRegion;
	private JLabel AboutVersionLabel;
	private JPanel footer;
	private JTextPane forthLine;
	private JTextPane fifthLine;
	private JTextPane viewDoc;
	private JTextPane website;

/**
 * The default constructor creates the components.
 * It also initializes the eventHandlers.
 */
	
	public ScatterPlotHowToView() {

		setResizable(false);
		initalizeComponents();
	}
	
	
	private  void initalizeComponents(){

		makeAboutWrapperRegion();

		makeAboutMainContentRegion();

		setWrapperGroupLayout();

		createLabels();

		setMainContentRegionLayout();
		
		setVisible(true);

	}

	private void makeAboutMainContentRegion() {
		mainContentRegion = new JPanel();	
		mainContentRegion.setBounds(6, 6, 490, 418);
		mainContentRegion.setBackground(Color.DARK_GRAY);
		
	}


	private void setMainContentRegionLayout() {
		mainContentRegion.setLayout(null);
		mainContentRegion.add(AboutVersionLabel);
		
		JTextPane secondLine = new JTextPane();
		secondLine.setBackground(Color.DARK_GRAY);
		secondLine.setForeground(Color.WHITE);
		secondLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		secondLine.setEditable(false);
		secondLine.setText("2 - Once click a new tab opens that contains the new plot");
		secondLine.setBounds(17, 66, 456, 18);
		mainContentRegion.add(secondLine);
		
		JTextPane firstLine = new JTextPane();
		firstLine.setBackground(Color.DARK_GRAY);
		firstLine.setForeground(Color.WHITE);
		firstLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		firstLine.setEditable(false);
		firstLine.setText("1 - Create a new plot by going to file -> create new plot");
		firstLine.setBounds(17, 36, 456, 18);
		mainContentRegion.add(firstLine);
		
		JTextPane thirdLine = new JTextPane();
		thirdLine.setBackground(Color.DARK_GRAY);
		thirdLine.setForeground(Color.WHITE);
		thirdLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		thirdLine.setEditable(false);
		thirdLine.setText("3 - Once the plot is created you can use the text fields to the right of the plot to add new points. Click add point to add the point.");
		thirdLine.setBounds(17, 96, 456, 32);
		mainContentRegion.add(thirdLine);
		{
			forthLine = new JTextPane();
			forthLine.setBackground(Color.DARK_GRAY);
			forthLine.setForeground(Color.WHITE);
			forthLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			forthLine.setEditable(false);
			forthLine.setText("4 - Once the points are created, they can be connected when you click on the \"Connect points\" button.");
			forthLine.setBounds(17, 140, 456, 32);
			mainContentRegion.add(forthLine);
		}
		{
			fifthLine = new JTextPane();
			fifthLine.setBackground(Color.DARK_GRAY);
			fifthLine.setForeground(Color.WHITE);
			fifthLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			fifthLine.setEditable(false);
			fifthLine.setText("Note that you can change the title, x and y labels of your plot anytime by using the fields below that plot and by pressing \"edit plot button\".");
			fifthLine.setBounds(17, 184, 456, 32);
			mainContentRegion.add(fifthLine);
		}
		{
			viewDoc = new JTextPane();
			viewDoc.setBackground(Color.DARK_GRAY);
			viewDoc.setForeground(Color.WHITE);
			viewDoc.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			viewDoc.setEditable(false);
			viewDoc.setText("You can view the documentation at:");
			viewDoc.setBounds(132, 357, 225, 18);
			mainContentRegion.add(viewDoc);
		}
		{
			website = new JTextPane();
			website.setBackground(Color.DARK_GRAY);
			website.setForeground(Color.WHITE);
			website.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			website.setEditable(false);
			website.setText("http://meyghani.net/scatterPlot");
			website.setBounds(143, 376, 203, 18);
			mainContentRegion.add(website);
		}
		
		JTextPane sixthLine = new JTextPane();
		sixthLine.setText("At the end you can save your files by putting the name of the your file below the save button and hit \"save\".");
		sixthLine.setForeground(Color.WHITE);
		sixthLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		sixthLine.setEditable(false);
		sixthLine.setBackground(Color.DARK_GRAY);
		sixthLine.setBounds(17, 228, 456, 32);
		mainContentRegion.add(sixthLine);
		
		JTextPane seventhLine = new JTextPane();
		seventhLine.setText("You can also load the files that you have already made. Make sure to include the .txt extension once filling the text field. For example put in samplePlot.txt and hit load.");
		seventhLine.setForeground(Color.WHITE);
		seventhLine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		seventhLine.setEditable(false);
		seventhLine.setBackground(Color.DARK_GRAY);
		seventhLine.setBounds(17, 279, 456, 48);
		mainContentRegion.add(seventhLine);
	}


	private void setWrapperGroupLayout() {
		wrapper.setLayout(null);
		wrapper.add(mainContentRegion);
		{
			makeAboutFooter();
		}
	}


	private void createLabels() {
		AboutVersionLabel = new JLabel("Instructions:");
		AboutVersionLabel.setForeground(Color.GRAY);
		AboutVersionLabel.setBounds(6, 6, 162, 18);
		AboutVersionLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		
	}


	private void makeAboutFooter() {
		footer = new JPanel();
		footer.setBackground(Color.DARK_GRAY);
		footer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(footer, BorderLayout.SOUTH);
		{
			okButton = new JButton("Ok");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					dispose();
				}
			});
			footer.add(okButton);
		}
		
	}


	private void makeAboutWrapperRegion() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Instructions");
		setSize(502, 491);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		wrapper.setBackground(Color.BLACK);
		wrapper.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(wrapper, BorderLayout.CENTER);
		
	}
}
