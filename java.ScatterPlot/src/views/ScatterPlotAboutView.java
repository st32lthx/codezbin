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

public class ScatterPlotAboutView extends JDialog {

	
	private final JPanel wrapper = new JPanel();
	private JButton okButton;
	private JPanel mainContentRegion;
	private JLabel authorLabel;
	private JLabel AboutVersionLabel;
	private JPanel footer;


public ScatterPlotAboutView() {
		
		setResizable(false);
		initalizeComponents();
	}
	
	
	private final void initalizeComponents(){

		makeAboutWrapperRegion();

		makeAboutMainContentRegion();

		setWrapperGroupLayout();

		createLabels();

		setMainContentRegionLayout();
		
		setVisible(true);

	}

	private void makeAboutMainContentRegion() {
		mainContentRegion = new JPanel();	
		mainContentRegion.setBounds(36, 39, 312, 141);
		mainContentRegion.setBackground(Color.DARK_GRAY);
		
	}


	private void setMainContentRegionLayout() {
		mainContentRegion.setLayout(null);
		mainContentRegion.add(AboutVersionLabel);
		mainContentRegion.add(authorLabel);
	}


	private void setWrapperGroupLayout() {
		wrapper.setLayout(null);
		wrapper.add(mainContentRegion);
		{
			makeAboutFooter();
		}
	}


	private void createLabels() {
		AboutVersionLabel = new JLabel("ScatterPlot Version 1.0");
		AboutVersionLabel.setForeground(Color.WHITE);
		AboutVersionLabel.setBounds(75, 48, 162, 18);
		AboutVersionLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		authorLabel = new JLabel("Amin Meyghani");
		authorLabel.setForeground(Color.WHITE);
		authorLabel.setBounds(101, 75, 109, 18);
		authorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		
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
		setTitle("About ScatterPlot");
		setSize(383, 269);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		wrapper.setBackground(Color.DARK_GRAY);
		wrapper.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(wrapper, BorderLayout.CENTER);
		
	}
}
